package com.example.i.mypage.data.mymarket

import retrofit2.Call
import retrofit2.http.*

interface MarketRetrofitInterface {
    // 나눔장터 작성 글 조회 API
    @GET("/mypage/market/{memIdx}/{page}")
    fun getMarket(
        @Path("memIdx") memIdx: Int,
        @Path("page") page: Int
    ): Call<MarketResponse>
}
