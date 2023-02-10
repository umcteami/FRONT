package com.example.i.chat.model

import com.example.i.chat.MessageActivity
import com.example.i.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChatService(val ChatInterface: ChatInterface) {
    // 채팅방 API
    fun tryGetChat(roomIdx: Int, memIdx: Int) {
        val ChatRetrofitInterface = ApplicationClass.sRetrofit.create(ChatRetrofitInterface::class.java)
        ChatRetrofitInterface.getChat(roomIdx, memIdx).enqueue(object: Callback<ChatResponse> {
            override fun onResponse(call: Call<ChatResponse>, response: Response<ChatResponse>) {
                (response.body() as ChatResponse?)?.let {
                    ChatInterface.onGetChatSuccess(
                        it
                    )
                }
            }

            override fun onFailure(call: Call<ChatResponse>, t: Throwable) {
                ChatInterface.onGetChatFailure(t.message ?: "통신 오류")
            }

        })
    }
}