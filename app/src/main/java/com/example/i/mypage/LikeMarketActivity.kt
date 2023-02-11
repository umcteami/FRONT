package com.example.i.mypage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.databinding.ActivityLikeMarketBinding
import com.example.i.market.MarketPostActivity
import com.example.i.mypage.data.LikeMarket
import com.example.i.mypage.data.LikeMarketRVAdapter

class LikeMarketActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityLikeMarketBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityLikeMarketBinding.inflate(layoutInflater)

        val LikeList: ArrayList<LikeMarket> = arrayListOf()
        val adapter = LikeMarketRVAdapter(LikeList)

        LikeList.apply{
            add(LikeMarket("3000원", "어쩌구저쩌구 사료", "10시간 전","조회 12", "2"))
            add(LikeMarket("3000원", "어쩌구저쩌구 사료", "10시간 전","조회 12", "2"))
            add(LikeMarket("3000원", "어쩌구저쩌구 사료", "10시간 전","조회 12", "2"))
            add(LikeMarket("3000원", "어쩌구저쩌구 사료", "10시간 전","조회 12", "2"))
            add(LikeMarket("3000원", "어쩌구저쩌구 사료", "10시간 전","조회 12", "2"))
            add(LikeMarket("3000원", "어쩌구저쩌구 사료", "10시간 전","조회 12", "2"))
            add(LikeMarket("3000원", "어쩌구저쩌구 사료", "10시간 전","조회 12", "2"))
        }

        viewBinding.recyclerview.layoutManager = LinearLayoutManager(this)
        viewBinding.recyclerview.adapter = adapter

        adapter!!.itemClick = object : LikeMarketRVAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val intent = Intent(this@LikeMarketActivity, MarketPostActivity::class.java)
                startActivity(intent)
            }
        }

        viewBinding.backBtn.setOnClickListener {
            finish()
        }
        setContentView(viewBinding.root)
    }
}