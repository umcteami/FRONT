package com.example.i.community.models

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CommentRetrofitInterface {
    @GET("/feeds/comment")
    fun getComment(
        @Query("boardType") boardType: Int,
        @Query("feedIdx") feedIdx: Int
    ): Call<CommentResponse>
}