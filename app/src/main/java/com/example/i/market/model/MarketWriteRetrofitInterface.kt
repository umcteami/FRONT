package com.example.i.market.model

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface MarketWriteRetrofitInterface {
    @Multipart
    @POST("/market")
    fun postMarketWrite(
        @Part("request") request : RequestBody,
        @Part images : List<MultipartBody.Part?>
    ) : Call<MarketWriteResponse>
}