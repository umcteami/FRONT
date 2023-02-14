package com.example.i.community.models

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface HomeSearchRetrofitInterface {
    //홈 검색창 API
    @GET("/home/search?")
    fun getHomeSearch(
        @Path("search_keyword") searchKeyword : String,
        @Path("page") page : Int,
        @Path("search_target") searchTarget : String
    ) : Call<HomeSearchResponse>
}