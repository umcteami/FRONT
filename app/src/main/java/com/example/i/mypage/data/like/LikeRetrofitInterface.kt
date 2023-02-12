package com.example.i.mypage.data.like

import retrofit2.Call
import retrofit2.http.*

interface LikeRetrofitInterface {
    // 좋아요한 게시글 API
    @GET("/mypage/like/{memIdx}/{page}")
    fun getWant(
        @Path("memIdx") memIdx: Int,
        @Path("page") page: Int
    ): Call<LikeResponse>
}
