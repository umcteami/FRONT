package com.example.i.chat.model

import com.example.i.config.BaseResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ChatDeleteRetrofitInterface {
    // 채팅방 삭제 API
    @POST("/chat/room/out")
    fun postChatDelete(
        @Body params: ChatDeleteRequest
    ): Call<BaseResponse>
}