package com.example.i.mypage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.i.R
import com.example.i.databinding.ActivityMyMarketBinding
import com.example.i.market.MarketP
import com.example.i.market.MarketPostActivity
import com.example.i.market.MarketPplRVAdapter

class MyMarketActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityMyMarketBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMyMarketBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val mkpList: ArrayList<MarketP> = arrayListOf()
        val adapter = MarketPplRVAdapter(mkpList)

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
        viewBinding.recyclerview.adapter = adapter

        adapter!!.itemClick = object : MarketPplRVAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val intent = Intent(this@MyMarketActivity, MarketPostActivity::class.java)
                startActivity(intent)
            }
        }

        viewBinding.backBtn.setOnClickListener {
            finish()
        }
    }
}