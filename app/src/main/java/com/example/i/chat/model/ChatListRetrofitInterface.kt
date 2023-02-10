package com.example.i.chat.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ChatListRetrofitInterface {
    // 채팅 목록 API
    @GET("/chat/rooms/{memIdx}")
    fun getChatList(
        @Path("memIdx") memIdx: Int
    ): Call<ChatListResponse>
}