package com.example.i.community.models

import com.example.i.config.BaseResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LikeChangeRetrofitInterface {
    @POST("/feeds/like/change")
    fun postLikeChange(
        @Body parmas: RequestLikeChange
    ): Call<BaseResponse>
}