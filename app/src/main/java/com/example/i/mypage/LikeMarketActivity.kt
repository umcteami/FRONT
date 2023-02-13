package com.example.i.mypage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.databinding.ActivityLikeMarketBinding
import com.example.i.login.memIdx
import com.example.i.market.MarketPostActivity
import com.example.i.mypage.data.LikeMarket
import com.example.i.mypage.data.LikeMarketRVAdapter
import com.example.i.mypage.data.want.WantInterface
import com.example.i.mypage.data.want.WantResponse
import com.example.i.mypage.data.want.WantService

class LikeMarketActivity : AppCompatActivity(), WantInterface {
    lateinit var viewBinding: ActivityLikeMarketBinding
    val LikeList: ArrayList<LikeMarket> = arrayListOf()
    val adapter = LikeMarketRVAdapter(LikeList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityLikeMarketBinding.inflate(layoutInflater)

        WantService(this).tryGetWant(1,1) // 찜한 물품들 API

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

    // 찜한 물품들 API
    override fun onGetWantSuccess(response: WantResponse) {
        // 받아온 정보와 UI 연결
        if(response.isSuccess){

            LikeList.apply{
                add(LikeMarket(response.result[3].toString(), response.result[4].toString(), response.result[5].toString(), response.result[6].toString(), response.result[7].toString()))
            }

            viewBinding.recyclerview.layoutManager = LinearLayoutManager(this)
            viewBinding.recyclerview.adapter = adapter
        }

        // Result message
        Toast.makeText(this, response.message, Toast.LENGTH_SHORT).show()
    }

    // 서버 연결 실패
    override fun onGetWantFailure(message: String) {
        Log.d("error", "오류 : $message")
    }
}