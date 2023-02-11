package com.example.i.community.talk.models.talkroom

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TalkroomRetrofitInterface {

    @GET("/feeds/story/all")
    fun getTalkroom(
        @Query("page") page: Int
    ): Call<TalkroomResponse>
}