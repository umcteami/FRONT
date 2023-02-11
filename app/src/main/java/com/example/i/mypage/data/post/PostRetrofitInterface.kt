package com.example.i.mypage.data.post

import com.example.i.mypage.data.like.LikeResponse
import retrofit2.Call
import retrofit2.http.*

interface PostRetrofitInterface {
    // 작성 글 조회 API
    @GET("/mypage/RSWrite/{memIdx}/{page}")
    fun getPost(
        @Path("memIdx") memIdx: Int,
        @Path("page") page: Int
    ): Call<PostResponse>

    // 일기장 작성 글 조회API
    @GET("/mypage/DWrite/{memIdx}/{end}")
    fun getDiary(
        @Path("memIdx") memIdx: Int,
        @Path("page") page: Int
    ): Call<PostResponse>
}
