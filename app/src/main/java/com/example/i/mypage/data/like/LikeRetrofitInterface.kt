package com.example.i.mypage.data.like

import com.example.i.mypage.data.want.WantResponse
import retrofit2.Call
import retrofit2.http.*

interface WantRetrofitInterface {
    // 좋아요 게시글 API
    @GET("/mypage/like/{memIdx}/{end}")
    fun getWant(
        @Path("memIdx") memIdx: Int,
        @Path("page") page: Int
    ): Call<WantResponse>
}
