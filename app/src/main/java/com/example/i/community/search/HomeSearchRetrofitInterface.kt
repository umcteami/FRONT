package com.example.i.community.search

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HomeSearchRetrofitInterface {
    //홈 검색창 API
    @GET("/home/search?")
    fun getHomeSearch(
        @Query("search_keyword") searchKeyword : String?,
        @Query("page") page : Int?,
        @Query("search_target") searchTarget : String
    ) : Call<HomeSearchResponse>
}