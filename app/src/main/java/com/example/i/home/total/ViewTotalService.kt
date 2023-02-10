package com.example.i.home.total

import retrofit2.http.GET
import retrofit2.Call


interface ViewTotalService {
    @GET ("/feeds")
    fun getViewTtl (): Call<ViewTotalResponse>
}