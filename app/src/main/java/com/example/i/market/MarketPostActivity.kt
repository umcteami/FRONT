package com.example.i.market

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.i.chat.MessageActivity
import com.example.i.chat.MessageListFragment
import com.example.i.databinding.ActivityMarketPostBinding

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
            startActivity(intent)
        }
    }
}