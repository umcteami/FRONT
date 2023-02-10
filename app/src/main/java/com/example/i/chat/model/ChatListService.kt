package com.example.i.chat.model

import com.example.i.config.ApplicationClass
import retrofit2.Call
import retrofit2.Response

class ChatListService(val ChatListInterface: ChatListInterface) {
    // 채팅 목록 API
    fun tryGetChatList(memIdx:Int){
        val ChatListRetrofitInterface = ApplicationClass.sRetrofit.create(ChatListRetrofitInterface::class.java)
        ChatListRetrofitInterface.getChatList(memIdx).enqueue(object: retrofit2.Callback<ChatListResponse> {
            override fun onResponse(call: Call<ChatListResponse>, response: Response<ChatListResponse>) {
                (response.body() as ChatListResponse?)?.let {
                    ChatListInterface.onGetChatListSuccess(
                        it
                    )
                }
            }

            override fun onFailure(call: Call<ChatListResponse>, t: Throwable) {
                ChatListInterface.onGetChatListFailure(t.message ?: "통신 오류")
            }
        })
    }
}