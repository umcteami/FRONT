package com.example.i.market.model

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Query

interface MarketListRetrofitInterface {

    @GET("/market/latest")
    fun getMarketList(
        @Query ("category") category: String? = null,
        @Query ("soldout") soldout: String? = null
    ): Call<MarketListResponse>
}