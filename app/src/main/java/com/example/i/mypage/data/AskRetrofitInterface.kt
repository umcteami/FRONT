package com.example.i.mypage.data

import com.example.i.config.BaseResponse
import retrofit2.Call
import retrofit2.http.*

interface AskRetrofitInterface {
    // 문의하기 API
    @POST("/mypage/ask")
    fun postAsk(@Body params: PostAskRequest): Call<BaseResponse>
}
