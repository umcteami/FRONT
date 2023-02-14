package com.example.i.mypage.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.i.databinding.FragmentProfileMarketBinding
import com.example.i.market.MarketP
import com.example.i.market.MarketPostActivity
import com.example.i.market.MarketPplRVAdapter


class ProfileMarketFragment : Fragment() {

    private lateinit var viewBinding: FragmentProfileMarketBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentProfileMarketBinding.inflate(inflater, container, false)

        val mkpList: ArrayList<MarketP> = arrayListOf()
        val adapter = MarketPplRVAdapter(mkpList)

        var img = "https://i-image.s3.ap-northeast-2.amazonaws.com/8568310d-73fb-4728-b11f-712d716c6416_Acer_Wallpaper_03_5000x2814.jpg"


        mkpList.apply{
            add(MarketP(img, "간식 나눔", "강아지 껌", "2", false))
            add(MarketP(img, "간식 나눔", "강아지 껌", "2", false))
            add(MarketP(img, "간식 나눔", "강아지 껌", "2", true))
            add(MarketP(img, "간식 나눔", "강아지 껌", "2", true))
            add(MarketP(img, "간식 나눔", "강아지 껌", "2", false))
            add(MarketP(img, "간식 나눔", "강아지 껌", "2", true))
        }

        viewBinding.marketRecyclerview.layoutManager = GridLayoutManager(requireActivity(), 3)
        viewBinding.marketRecyclerview.adapter = adapter

        adapter!!.itemClick = object : MarketPplRVAdapter.ItemClick {

            override fun onClick(view: View, position: Int) {
                val intent = Intent(activity, MarketPostActivity::class.java)
                startActivity(intent)
            }
        }

        return viewBinding.root
    }
}