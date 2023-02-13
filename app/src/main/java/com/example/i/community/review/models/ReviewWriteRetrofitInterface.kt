package com.example.i.community.review.models

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ReviewWriteRetrofitInterface {
    @Multipart
    @POST("/review/write")
    fun postReviewWrite(
        @Part("request") request : RequestBody,
        @Part img : List<MultipartBody.Part?>
    ) : Call<ReviewWriteResponse>
}