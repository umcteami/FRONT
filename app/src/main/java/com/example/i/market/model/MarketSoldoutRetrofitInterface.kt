package com.example.i.market.model

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.PUT
import retrofit2.http.Query

interface MarketSoldoutRetrofitInterface {
    //거래완료 설정API
    @PUT("/market/soldout?")
    fun putMarketSoldout(
        @Body params : MarketSoldoutRequest,
        @Query("marketIdx") marketIdx : Int
    ) : Call<MarketSoldoutResponse>
}