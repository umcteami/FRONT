package com.example.i.home.model

import retrofit2.Call
import retrofit2.http.GET

interface TtlListRetrofitInterface {

        @GET("/feeds")
        fun getTtlList(): Call<TtlListResponse>
}