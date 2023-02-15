package com.example.i.community.search

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ReviewSearchRetrofitInterface {
    @GET("/review/search?")
    fun getReviewSearch(
        @Query("search_keyword")searchKeyword:String?,
        @Query("page")page:Int?
    ): Call<ReviewSearchResponse>
}