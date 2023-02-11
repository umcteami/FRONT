package com.example.i.home

import retrofit2.Call
import retrofit2.http.GET


interface ViewTtlRetrofitInterface {
    @GET ("/feeds")
    fun getViewTtl(): Call<ViewTtlResponse>
}