package com.example.i.chat.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ChatRetrofitInterface {
    // 채팅방 API
    @GET("/chat/room/{roomIdx}/{memIdx}")
    fun getChat(
        @Path("roomIdx") roomIdx: Int,
        @Path("memIdx") memIdx: Int
    ): Call<ChatResponse>
}