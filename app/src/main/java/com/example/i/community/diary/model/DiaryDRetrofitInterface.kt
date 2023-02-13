package com.example.i.community.diary.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DiaryDRetrofitInterface {
    @GET("/feeds/diary?")
    fun getDiaryD(
        @Query("roomType")roomType: Int
    ): Call<DiaryDResponse>
}