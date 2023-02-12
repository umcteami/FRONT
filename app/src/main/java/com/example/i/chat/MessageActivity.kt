package com.example.i.chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.chat.model.*
import com.example.i.config.BaseResponse
import com.example.i.databinding.ActivityMessageBinding
import com.example.i.home.model.ChatService
import java.text.SimpleDateFormat
import kotlin.collections.ArrayList

class MessageActivity : AppCompatActivity(), ChatInterface, ChatDeleteInterface {

    private lateinit var viewBinding: ActivityMessageBinding
    val cList: ArrayList<Chat> = arrayListOf()
    val adapter = ChatRVAdpater(cList)
    var memIdx: Int = 0
    var roomIdx: Int = 0
    //var memIdx: Int = 8
    //var roomIdx: Int = 17

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMessageBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        memIdx = intent.getIntExtra("memIdx", 1)
        roomIdx = intent.getIntExtra("roomIdx", 1)

        viewBinding.backBtn.setOnClickListener {
            val body =  ChatDeleteRequest (roomIdx, memIdx)
            ChatOutService(this).tryPostChatOut(body)
            finish()
        }

        var nick = intent.getStringExtra("nick")
        viewBinding.tvName.text = nick

        ChatService(this).tryGetChat(roomIdx, memIdx)

        viewBinding.btSend.setOnClickListener {

            sendMessage()

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

    fun sendMessage() {
        val date: Long = System.currentTimeMillis()

        // 20xx년 xx월 xx일만 나오게 하는 식
        val sdf = SimpleDateFormat("yyyy-MM-dd hh:mm:ss")

        val getTime = sdf.format(date)
        val chatImg: List<String> = mutableListOf()

        cList.apply {
            add(
                Chat(
                    memIdx,
                    memIdx,
                    viewBinding.etChat.text.toString(),
                    chatImg,
                    null,
                    getTime.toString(),
                    false
                )
            )
        }

        adapter.notifyDataSetChanged()

        viewBinding.etChat.setText("")
    }

    override fun onPostChatDeleteSuccess(response: BaseResponse) {
        if (response.isSuccess) {
            Log.d("success", "success")
        }
    }

    override fun onPostChatDeleteFailure(message: String) {
        Log.d("error", "오류: $message")
    }
}
