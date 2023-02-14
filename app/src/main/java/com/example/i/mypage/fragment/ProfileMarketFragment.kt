package com.example.i.mypage.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.i.databinding.FragmentProfileMarketBinding
import com.example.i.market.MarketP
import com.example.i.market.MarketPostActivity
import com.example.i.market.MarketPplRVAdapter
import com.example.i.market.model.MarketUserListInterface
import com.example.i.market.model.MarketUserListResponse
import com.example.i.market.model.MarketUserListService


class ProfileMarketFragment : Fragment(), MarketUserListInterface {

    private lateinit var viewBinding: FragmentProfileMarketBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentProfileMarketBinding.inflate(inflater, container, false)

        MarketUserListService(this).tryGetMarketUserList(1)

        return viewBinding.root
    }

    override fun onGetMarketUserListSuccess(response: MarketUserListResponse) {
        if (response.isSuccess) {
            val mkpList: ArrayList<MarketP> = arrayListOf()
            val adapter = MarketPplRVAdapter(mkpList)
            val index: Int = response.result.size - 1

            for (i in 0..index) {
                mkpList.apply {
                    add(
                        MarketP(
                            response.result[i].img,
                            response.result[i].title,
                            response.result[i].content,
                            response.result[i].hit.toString(),
                            response.result[i].liked
                        )
                    )
                }
            }

            viewBinding.marketRecyclerview.layoutManager = GridLayoutManager(requireActivity(), 3)
            viewBinding.marketRecyclerview.adapter = adapter

            adapter!!.itemClick = object : MarketPplRVAdapter.ItemClick {

                override fun onClick(view: View, position: Int) {
                    val intent = Intent(activity, MarketPostActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }

    override fun onGetChatListFailure(message: String) {
        Log.d("error","오류: $message")
    }
}