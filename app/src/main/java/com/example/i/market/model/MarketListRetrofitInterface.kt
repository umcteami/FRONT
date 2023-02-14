package com.example.i.market.model

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Query

interface MarketListRetrofitInterface {

    @GET("/market/latest")
    fun getMarketList(
        @Query ("category") category: String,
        @Query ("soldout") soldout: String
    ): retrofit2.Call<MarketListResponse>
}