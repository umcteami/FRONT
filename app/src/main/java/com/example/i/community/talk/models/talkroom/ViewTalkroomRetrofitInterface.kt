package com.example.i.community.talk.models.talkroom

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ViewTalkroomRetrofitInterface {
    @GET("/feeds/story/{storyIdx}?")
    fun getViewTalkroom(
        @Path("storyIdx") storyIdx: Int,
        @Query("memIdx")  memIdx: Int
    ): Call<ViewTalkroomResponse>

}