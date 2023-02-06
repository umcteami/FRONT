package com.example.i.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.databinding.ActivityLikeMarketBinding
import com.example.i.mypage.data.LikeMarket
import com.example.i.mypage.data.LikeMarketRVAdapter

class LikeMarketActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityLikeMarketBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityLikeMarketBinding.inflate(layoutInflater)

        val LikeList: ArrayList<LikeMarket> = arrayListOf()

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
        viewBinding.recyclerview.adapter = LikeMarketRVAdapter(LikeList)

        viewBinding.backBtn.setOnClickListener {
            finish()
        }
        setContentView(viewBinding.root)
    }
}