package com.example.i.market.model

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Query

interface MarketUserListRetroInterface {
    // 나눔 장터 판매자별 판매글 조회 API
    @GET("/market/list")
    fun getMarketUserList(
        @Body params: MarketUserListRequest,
        @Query("userIdx") userIdx: Int
    ): Call<MarketUserListResponse>
}