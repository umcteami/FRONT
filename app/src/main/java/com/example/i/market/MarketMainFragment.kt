package com.example.i.market

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.i.R
import com.example.i.databinding.FragmentMarketMainBinding

class MarketMainFragment: Fragment() {
    private lateinit var viewBinding: FragmentMarketMainBinding

    private var dots = arrayOfNulls<Button>(3)

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

        val marketVPAdapter = MarketVPAdapter(requireActivity())
        viewBinding.vpPpl.adapter = marketVPAdapter

        dotsIndicator()

        viewBinding.vpPpl.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                selectedIndicator(position)
            }
        })

//        var snapHelper = PagerSnapHelper()
//        val mkpList: ArrayList<MarketP> = arrayListOf()
//        val indicator = IndicatorDecoration()
//
//        mkpList.apply{
//            add(MarketP("무료나눔", "강아지 껌", "2"))
//            add(MarketP("무료나눔", "강아지 껌", "2"))
//            add(MarketP("무료나눔", "강아지 껌", "2"))
//            add(MarketP("무료나눔", "강아지 껌", "2"))
//            add(MarketP("무료나눔", "강아지 껌", "2"))
//            add(MarketP("무료나눔", "강아지 껌", "2"))
//            add(MarketP("무료나눔", "강아지 껌", "2"))
//            add(MarketP("무료나눔", "강아지 껌", "2"))
//            add(MarketP("무료나눔", "강아지 껌", "2"))
//            add(MarketP("무료나눔", "강아지 껌", "2"))
//            add(MarketP("무료나눔", "강아지 껌", "2"))
//            add(MarketP("무료나눔", "강아지 껌", "2"))
//            add(MarketP("무료나눔", "강아지 껌", "2"))
//            add(MarketP("무료나눔", "강아지 껌", "2"))
//            add(MarketP("무료나눔", "강아지 껌", "2"))
//            add(MarketP("무료나눔", "강아지 껌", "2"))
//            add(MarketP("무료나눔", "강아지 껌", "2"))
//
//        }
//
//        viewBinding.rvPpl.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.HORIZONTAL, false)
//        viewBinding.rvPpl.adapter = MarketPplRVAdapter(mkpList)
//        viewBinding.rvPpl.addItemDecoration(indicator)
//        snapHelper.attachToRecyclerView(viewBinding.rvPpl)


        val mkList: ArrayList<Market> = arrayListOf()
        val adapter = MarketRVAdapter(mkList)
        val customDecoration = CustomDecoration(2f, 2f, Color.rgb(0xB4,0xB4,0xB4))

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
        viewBinding.rvMarket.adapter = adapter
        viewBinding.rvMarket.addItemDecoration(customDecoration)
    }

    private fun dotsIndicator() {
        for (i: Int in 0 until 3) {
            dots[i] = Button(requireActivity())

            var params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT
            )

            //params.leftMargin = 30
            dots[i]?.layoutParams = params
            viewBinding.dotsLayout.addView(dots[i])


        }
    }

    private fun selectedIndicator(position: Int) {

        for (i: Int in 0 until 3){

            if (i == position) {
                dots[i]?.setBackgroundResource(R.drawable.select_dot)
            }else {
                dots[i]?.setBackgroundResource(R.drawable.default_dot)
            }
        }
    }
}
