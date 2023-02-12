package com.example.i.chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.chat.model.ChatInterface
import com.example.i.chat.model.ChatResponse
import com.example.i.chat.model.ChatService
import com.example.i.databinding.ActivityMessageBinding
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MessageActivity : AppCompatActivity(), ChatInterface {

    private lateinit var viewBinding: ActivityMessageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMessageBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.backBtn.setOnClickListener {
            finish()
        }

        var memIdx = intent.getIntExtra("memIdx", 1)
        var roomIdx = intent.getIntExtra("roomIdx", 1)

        ChatService(this).tryGetChat(roomIdx, memIdx)


        val cList: ArrayList<Chat> = arrayListOf()
        val adapter = ChatRVAdpater(cList)

        viewBinding.rvChatting.layoutManager = LinearLayoutManager(this@MessageActivity)

        viewBinding.btSend.setOnClickListener {
            var item = sendMessage()

            cList.add(item)
            adapter.notifyDataSetChanged()
        }
    }

    override fun onGetChatSuccess(response: ChatResponse) {
        if (response.isSuccess) {
            viewBinding.tvName.text = response.result.senderNick
        }
    }

    override fun onGetChatFailure(message: String) {
        Log.d("error", "오류: $message")
    }

    fun sendMessage(): Chat {
        val now = System.currentTimeMillis()
        val date = Date(now)
        // 20xx년 xx월 xx일만 나오게 하는 식
        val sdf = SimpleDateFormat("yyyy-MM-dd")

        val getTime = sdf.format(date)

        val item = Chat(viewBinding.etChat.text.toString(), "url", getTime, false)

        viewBinding.etChat.setText("")

        return item
    }
}
