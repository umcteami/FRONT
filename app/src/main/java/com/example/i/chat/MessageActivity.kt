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

        ChatService(this).tryGetChat(17,8)

    }

    override fun onGetChatSuccess(response: ChatResponse) {
        if (response.isSuccess) {

            val index: Int = response.result.size!! - 1

            val cList: ArrayList<Chat> = arrayListOf()
            val adapter = ChatRVAdpater(cList)

            for (i in 0 .. index) {

                viewBinding.tvName.text = response.result[i]!!.senderNick!!

                for (j in 0 .. response.result[i].chatImg.size!! - 1) {
                    cList.apply {
                        add(
                            Chat(
                                response.result[i].message,
                                response.result[i].chatImg[j],
                                response.result[i].chatTime,
                                false
                            )
                        )
                    }
                }
            }

            viewBinding.rvChatting.layoutManager = LinearLayoutManager(this)

            viewBinding.btSend.setOnClickListener {
                var item = sendMessage()

                cList.add(item)
                adapter.notifyDataSetChanged()
            }
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
