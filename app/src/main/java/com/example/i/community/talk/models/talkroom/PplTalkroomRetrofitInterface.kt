package com.example.i.community.talk.models.talkroom

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PplTalkroomRetrofitInterface {

    @GET("/feeds/hot/{boardType}")
    fun getPplTalkroom(
        @Path("boardType") boardType: String,
        @Query("filter") filter: Int,
        @Query("page") page: Int,
        @Query("roomType") roomType: Int
    ): Call<PplTalkroomResponse>
}