package com.example.i.market

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import com.example.i.R
import com.example.i.databinding.FragmentPpl1Binding
import com.example.i.market.model.MarketUserListInterface
import com.example.i.market.model.MarketUserListResponse
import com.example.i.market.model.MarketUserListService

class Ppl1Fragment : Fragment(), MarketUserListInterface {

    private lateinit var viewBinding: FragmentPpl1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentPpl1Binding.inflate(inflater, container, false)

        MarketUserListService(this).tryGetMarketUserList(1)

        return viewBinding.root
    }

    override fun onGetMarketUserListSuccess(response: MarketUserListResponse) {
        val item = mutableListOf<MarketP>()

        for (i in 0..5) {
            item.apply {
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

        val adapter = MarketGVAdapter(item, requireActivity())
        viewBinding.gvPpl.adapter = adapter

        viewBinding.gvPpl.setOnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(activity, MarketPostActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onGetChatListFailure(message: String) {
        Log.d("error", "오류: $message")
    }
}