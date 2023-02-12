package com.example.i.chat.model

import com.example.i.config.BaseResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ChatOutRetrofitInterface {
    // 채팅방 나가기 API
    @POST("/chat/room/out")
    fun postChatOut(
        @Body params: ChatDeleteRequest
    ): Call<BaseResponse>
}