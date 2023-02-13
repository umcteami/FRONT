package com.example.i.community.review.models

import retrofit2.Call
import retrofit2.http.GET

interface ReviewListRetrofitInterface {
    @GET("/review")
    fun getReviewList(): Call<ReviewListResponse>
}