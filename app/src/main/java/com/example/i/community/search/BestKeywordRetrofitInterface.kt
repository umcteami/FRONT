package com.example.i.community.search

import retrofit2.Call
import retrofit2.http.GET

interface BestKeywordRetrofitInterface {
    @GET("/search/bestkeyword")
    fun getBestKeyword(

    ): Call<BestKeywordResponse>
}