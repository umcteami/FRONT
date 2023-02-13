package com.example.i.home.model

import retrofit2.Call
import retrofit2.http.GET

interface PplListRetrofitInterface {

    @GET("/feeds/hot")
    fun getPplList(): Call<PplListResponse>
}