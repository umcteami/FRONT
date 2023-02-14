package com.example.i.market

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.i.chat.MessageActivity
import com.example.i.databinding.ActivityMarketPostBinding
import com.example.i.mypage.FriendProfileActivity

class MarketPostActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMarketPostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMarketPostBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        viewBinding.btBack.setOnClickListener {
            finish()
        }

        viewBinding.btChat.setOnClickListener {
            val intent = Intent(this, MessageActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }

        var img =
            "https://i-image.s3.ap-northeast-2.amazonaws.com/8568310d-73fb-4728-b11f-712d716c6416_Acer_Wallpaper_03_5000x2814.jpg"

        val item = mutableListOf<MarketP>()

        item.apply {
            add(MarketP(img, "간식 나눔", "강아지 껌", "2", false))
            add(MarketP(img, "간식 나눔", "강아지 껌", "2", false))
            add(MarketP(img, "간식 나눔", "강아지 껌", "2", true))
            add(MarketP(img, "간식 나눔", "강아지 껌", "2", true))
            add(MarketP(img, "간식 나눔", "강아지 껌", "2", false))
            add(MarketP(img, "간식 나눔", "강아지 껌", "2", true))
        }

        val adapter = MarketGVAdapter(item, this)
        viewBinding.gvMore.adapter = adapter

        viewBinding.gvMore.setOnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(this, MarketPostActivity::class.java)
            startActivity(intent)

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
    }
}