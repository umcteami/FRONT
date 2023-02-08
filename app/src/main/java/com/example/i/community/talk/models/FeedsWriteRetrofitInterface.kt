package com.example.i.community.talk.models

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface FeedsWriteRetrofitInterface {
    @POST("/feeds/write")
    fun postFeedsWrite(@Body params : PostFeedsWriteRequest) : Call<FeedsWriteResponse>
}