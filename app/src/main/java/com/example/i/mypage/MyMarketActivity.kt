package com.example.i.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.i.R
import com.example.i.databinding.ActivityMyMarketBinding
import com.example.i.market.IndicatorDecoration
import com.example.i.market.MarketP
import com.example.i.market.MarketPplRVAdapter
import com.example.i.mypage.data.LikeMarket
import com.example.i.mypage.data.LikeMarketRVAdapter

class MyMarketActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityMyMarketBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMyMarketBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val mkpList: ArrayList<MarketP> = arrayListOf()

        mkpList.apply{
            add(MarketP(R.drawable.img_post, "무료나눔", "강아지 껌", "2"))
            add(MarketP(R.drawable.img_post, "무료나눔", "강아지 껌", "2"))
            add(MarketP(R.drawable.img_post, "무료나눔", "강아지 껌", "2"))
            add(MarketP(R.drawable.img_post, "무료나눔", "강아지 껌", "2"))
            add(MarketP(R.drawable.img_post, "무료나눔", "강아지 껌", "2"))
            add(MarketP(R.drawable.img_post, "무료나눔", "강아지 껌", "2"))
            add(MarketP(R.drawable.img_post, "무료나눔", "강아지 껌", "2"))
            add(MarketP(R.drawable.img_post, "무료나눔", "강아지 껌", "2"))
            add(MarketP(R.drawable.img_post, "무료나눔", "강아지 껌", "2"))
            add(MarketP(R.drawable.img_post, "무료나눔", "강아지 껌", "2"))
            add(MarketP(R.drawable.img_post, "무료나눔", "강아지 껌", "2"))
            add(MarketP(R.drawable.img_post, "무료나눔", "강아지 껌", "2"))
            add(MarketP(R.drawable.img_post, "무료나눔", "강아지 껌", "2"))
            add(MarketP(R.drawable.img_post, "무료나눔", "강아지 껌", "2"))
            add(MarketP(R.drawable.img_post, "무료나눔", "강아지 껌", "2"))
            add(MarketP(R.drawable.img_post, "무료나눔", "강아지 껌", "2"))
            add(MarketP(R.drawable.img_post, "무료나눔", "강아지 껌", "2"))
        }

        viewBinding.recyclerview.layoutManager = GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false)
        viewBinding.recyclerview.adapter = MarketPplRVAdapter(mkpList)

        viewBinding.backBtn.setOnClickListener {
            finish()
        }
    }
}