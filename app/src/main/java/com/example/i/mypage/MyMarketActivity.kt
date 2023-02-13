package com.example.i.mypage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.i.R
import com.example.i.databinding.ActivityMyMarketBinding
import com.example.i.market.MarketP
import com.example.i.market.MarketPostActivity
import com.example.i.market.MarketPplRVAdapter
import com.example.i.mypage.data.mymarket.MarketInterface
import com.example.i.mypage.data.mymarket.MarketResponse
import com.example.i.mypage.data.mymarket.MarketService

class MyMarketActivity : AppCompatActivity(), MarketInterface {
    lateinit var viewBinding: ActivityMyMarketBinding

    val mkpList: ArrayList<MarketP> = arrayListOf()
    val adapter = MarketPplRVAdapter(mkpList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMyMarketBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        MarketService(this).tryGetMarket(33,0)     // 나눔장터 작성 글 조회 API

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
    // 나눔장터 작성 글 조회 API
    override fun onGetMarketSuccess(response: MarketResponse) {
        // 받아온 정보와 UI 연결
        if(response.isSuccess){

            viewBinding.tvCount.text = "총 ${response.size}개의 나눔장터 상품이 있어요"

            mkpList.apply{
                // add(MarketP(R.drawable.img_post, "무료나눔", "강아지 껌", "2"))
                add(MarketP(R.drawable.img_post, response.result[0].toString(), response.result[1].toString(), response.result[2].toString()))
            }

            viewBinding.recyclerview.layoutManager = GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false)
            viewBinding.recyclerview.adapter = adapter
        }

        // Result message
        Toast.makeText(this, response.message, Toast.LENGTH_SHORT).show()
    }

    // 서버 연결 실패
    override fun onGetMarketFailure(message: String) {
        viewBinding.tvCount.text = "총 0개의 나눔장터 상품이 있어요"
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        Log.d("error", "오류 : $message")
    }
}