package com.example.i.home.model

import retrofit2.Call
import retrofit2.http.GET

interface HotTtlListRetrofitInterface {
    @GET("/feeds/hot")
    fun getHotTtlList(): Call<HotTtlListResponse>
}