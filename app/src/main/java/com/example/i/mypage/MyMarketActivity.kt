package com.example.i.mypage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.i.databinding.ActivityMyMarketBinding
import com.example.i.login.memIdx
import com.example.i.market.MarketPostActivity
import com.example.i.mypage.data.mymarket.*
import com.example.i.mypage.data.want.WantService
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.scheduleAtFixedRate

class MyMarketActivity : AppCompatActivity(), MarketInterface {
    lateinit var viewBinding: ActivityMyMarketBinding

    val mkpList: ArrayList<MyMarket> = arrayListOf()
    val adapter = MyMarketRVAdapter(mkpList)
    val page = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMyMarketBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        // 1시간 간격으로 반복
        Timer().scheduleAtFixedRate(1000, 3600000) {
            MarketService(this@MyMarketActivity).tryGetMarket(memIdx, page)     // 나눔장터 작성 글 조회 API
            page + 1
        }

        adapter!!.itemClick = object : MyMarketRVAdapter.ItemClick {
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
            val index: Int = response.result.size - 1
            viewBinding.tvCount.text = "총 ${response.size}개의 나눔장터 상품이 있어요"

            for (i in 0 ..index) {
                if (response.size != 0) {
                    mkpList.apply {
                        add(
                            MyMarket(
                                response.result[i].feedImg.toString(),
                                response.result[i].title.toString(),
                                response.result[i].title.toString(),
                                response.result[i].boarIdx.toString(),
                            )
                        )
                    }
                }
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