package com.example.i.community.search

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface StorySearchRetrofitInterface {
    @GET("/story/search?")
    fun getStorySearch(
        @Query("category")category:String?,
        @Query("search_keyword")searchKeyword:String?,
        @Query("page")page:Int?,
        @Query("search_target")searchTarget:String
    ): Call<StorySearchResponse>
}