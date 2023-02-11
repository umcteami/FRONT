package com.example.i.chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.i.chat.model.ChatInterface
import com.example.i.chat.model.ChatResponse
import com.example.i.chat.model.ChatService
import com.example.i.databinding.ActivityMessageBinding

class MessageActivity : AppCompatActivity(), ChatInterface {

    private lateinit var viewBinding: ActivityMessageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMessageBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.backBtn.setOnClickListener {
            finish()
        }

        var nickname = intent.getStringExtra("nickname")

        viewBinding.tvName.text = nickname

        ChatService(this).tryGetChat(2, 2)
    }

    override fun onGetChatSuccess(response: ChatResponse) {
        if (response.isSuccess) {
            Log.d("success", "성공")
        }
    }

    override fun onGetChatFailure(message: String) {
        Log.d("error", "오류: $message")
    }
}