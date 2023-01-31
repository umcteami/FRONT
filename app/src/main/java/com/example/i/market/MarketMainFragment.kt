package com.example.i.market

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.i.R
import com.example.i.databinding.FragmentMarketMainBinding

class MarketMainFragment: Fragment() {
    lateinit var viewBinding: FragmentMarketMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentMarketMainBinding.inflate(layoutInflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var snapHelper = PagerSnapHelper()
        val mkpList: ArrayList<MarketP> = arrayListOf()
        val indicator = IndicatorDecoration()

        mkpList.apply{
            add(MarketP("무료나눔", "강아지 껌", "2"))
            add(MarketP("무료나눔", "강아지 껌", "2"))
            add(MarketP("무료나눔", "강아지 껌", "2"))
            add(MarketP("무료나눔", "강아지 껌", "2"))
            add(MarketP("무료나눔", "강아지 껌", "2"))
            add(MarketP("무료나눔", "강아지 껌", "2"))
            add(MarketP("무료나눔", "강아지 껌", "2"))
            add(MarketP("무료나눔", "강아지 껌", "2"))
            add(MarketP("무료나눔", "강아지 껌", "2"))
            add(MarketP("무료나눔", "강아지 껌", "2"))
            add(MarketP("무료나눔", "강아지 껌", "2"))
            add(MarketP("무료나눔", "강아지 껌", "2"))
            add(MarketP("무료나눔", "강아지 껌", "2"))
            add(MarketP("무료나눔", "강아지 껌", "2"))
            add(MarketP("무료나눔", "강아지 껌", "2"))
            add(MarketP("무료나눔", "강아지 껌", "2"))
            add(MarketP("무료나눔", "강아지 껌", "2"))

        }

        viewBinding.rvPpl.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.HORIZONTAL, false)
        viewBinding.rvPpl.adapter = MarketPplRVAdapter(mkpList)
        viewBinding.rvPpl.addItemDecoration(indicator)
        snapHelper.attachToRecyclerView(viewBinding.rvPpl)


        val mkList: ArrayList<Market> = arrayListOf()
        val customDecoration = CustomDecoration(2f, 2f, Color.GRAY)

        mkList.apply{
            add(Market("무료나눔", "강아지 껌", "7시간 전","조회 12", "2"))
            add(Market("무료나눔", "강아지 껌", "7시간 전","조회 12", "2"))
            add(Market("무료나눔", "강아지 껌", "7시간 전","조회 12", "2"))
            add(Market("무료나눔", "강아지 껌", "7시간 전","조회 12", "2"))
            add(Market("무료나눔", "강아지 껌", "7시간 전","조회 12", "2"))
            add(Market("무료나눔", "강아지 껌", "7시간 전","조회 12", "2"))
            add(Market("무료나눔", "강아지 껌", "7시간 전","조회 12", "2"))
            add(Market("무료나눔", "강아지 껌", "7시간 전","조회 12", "2"))
        }

        viewBinding.rvMarket.layoutManager = LinearLayoutManager(context)
        viewBinding.rvMarket.adapter = MarketRVAdapter(mkList)
        viewBinding.rvMarket.addItemDecoration(customDecoration)

    }
}
