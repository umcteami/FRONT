package com.example.i.chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.i.databinding.ActivityMessageBinding

class MessageActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMessageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMessageBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        var nickname = intent.getStringExtra("nickname")

        viewBinding.tvName.text = nickname
    }
}