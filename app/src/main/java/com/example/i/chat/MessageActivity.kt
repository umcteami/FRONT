package com.example.i.chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.chat.model.ChatInterface
import com.example.i.chat.model.ChatResponse
import com.example.i.databinding.ActivityMessageBinding
import com.example.i.home.model.ChatService
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MessageActivity : AppCompatActivity(), ChatInterface {

    private lateinit var viewBinding: ActivityMessageBinding
    val cList: ArrayList<Chat> = arrayListOf()
    val adapter = ChatRVAdpater(cList)
   // var memIdx = intent.getIntExtra("memIdx", 1)
   // var roomIdx = intent.getIntExtra("roomIdx", 1)
    var memIdx: Int = 8
    var roomIdx: Int = 17

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMessageBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.backBtn.setOnClickListener {
            finish()
        }

        ChatService(this).tryGetChat(roomIdx, memIdx)

        viewBinding.btSend.setOnClickListener {
            var item = sendMessage()

            cList.add(item)
            adapter.notifyDataSetChanged()
        }

    }

    override fun onGetChatSuccess(response: ChatResponse) {
        if (response.isSuccess) {

            val index: Int = response.result.size!! - 1

            cList.apply {
                for (i in 0..index) {
                    add(
                        Chat(
                            memIdx,
                            response.result[i].sender,
                            response.result[i].message,
                            response.result[i].chatImg,
                            response.result[i].senderProfile,
                            response.result[i].chatTime,
                            false
                        )
                    )
                }
            }

            adapter.notifyDataSetChanged()

            viewBinding.rvChatting.layoutManager = LinearLayoutManager(this@MessageActivity)
            viewBinding.rvChatting.adapter = adapter

        }
    }

    override fun onGetChatFailure(message: String) {
        Log.d("error", "오류: $message")
    }

    fun sendMessage(): Chat {
        val now = System.currentTimeMillis()
        val date = Date(now)
        // 20xx년 xx월 xx일만 나오게 하는 식
        val sdf = SimpleDateFormat("yy-MM-dd hh:mm")

        val getTime = sdf.format(date)
        val chatImg: List<String> = mutableListOf()

        val item = Chat(memIdx,memIdx, viewBinding.etChat.text.toString(), chatImg, null, getTime, false)

        viewBinding.etChat.setText("")

        return item
    }
}
