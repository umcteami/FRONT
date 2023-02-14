package com.example.i.market.model

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Query

interface MarketListRetrofitInterface {

    @GET("/market/latest")
    fun getMarketList(
        @Query ("userIdx") userIdx: Int? = null
    ): Call<MarketListResponse>
}