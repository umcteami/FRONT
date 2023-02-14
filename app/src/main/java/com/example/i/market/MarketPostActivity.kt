package com.example.i.market

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.i.chat.MessageActivity
import com.example.i.databinding.ActivityMarketPostBinding
import com.example.i.market.model.MarketUserListInterface
import com.example.i.market.model.MarketUserListResponse
import com.example.i.market.model.MarketUserListService
import com.example.i.mypage.FriendProfileActivity

class MarketPostActivity : AppCompatActivity(), MarketUserListInterface {

    private lateinit var viewBinding: ActivityMarketPostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMarketPostBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        MarketUserListService(this).tryGetMarketUserList(39,17)

        viewBinding.btBack.setOnClickListener {
            finish()
        }

        viewBinding.btChat.setOnClickListener {
            val intent = Intent(this, MessageActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }

        viewBinding.gvMore.setOnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(this, MarketPostActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }

        viewBinding.btMore.setOnClickListener {
            val intent = Intent(this, FriendProfileActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onGetMarketUserListSuccess(response: MarketUserListResponse) {
        if(response.isSuccess) {

            val item = mutableListOf<MarketP>()
            val size = response.result.size

            if (size < 6) {
                for (i in 0..size - 1) {
                    item.apply {
                        add(
                            MarketP(
                                response.result[i].img,
                                response.result[i].title,
                                response.result[i].content,
                                response.result[i].hit.toString(),
                                response.result[i].liked
                            )
                        )
                    }
                }
            } else {
                for (i in 0..5) {
                    item.apply {
                        add(
                            MarketP(
                                response.result[i].img,
                                response.result[i].title,
                                response.result[i].content,
                                response.result[i].hit.toString(),
                                response.result[i].liked
                            )
                        )
                    }
                }
            }

            val adapter = MarketGVAdapter(item, this)
            viewBinding.gvMore.adapter = adapter
        }
    }

    override fun onGetChatListFailure(message: String) {
        Log.d("error", "오류: $message")
    }
}