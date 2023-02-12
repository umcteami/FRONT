package com.example.i.mypage.data.want

import retrofit2.Call
import retrofit2.http.*

interface WantRetrofitInterface {
    // 찜한 물품들 API
    @GET("/mypage/want/{memIdx}/{page}")
    fun getWant(
        @Path("memIdx") memIdx: Int,
        @Path("page") page: Int
    ): Call<WantResponse>
}
