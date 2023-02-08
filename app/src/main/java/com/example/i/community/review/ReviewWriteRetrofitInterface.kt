package com.example.i.community.review

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ReviewWriteRetrofitInterface {
    @POST("/review/write")
    fun postReviewWrite(@Body params : PostReviewWriteRequest) : Call<ReviewWriteResponse>
}