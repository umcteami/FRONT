package com.example.i.market.model

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface MarketWriteRetrofitInterface {
    @POST("/market")
    fun postMarketWrite(@Body params : PostMarketWriteRequest) : Call<MarketWriteResponse>
}