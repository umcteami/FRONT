package com.example.i.community.talk.models.talk

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TalkRetrofitInterface {

    @GET("/feeds/story?")
    fun getTalk(
        @Query("roomType")roomType: Int
    ): Call<TalkResponse>
}