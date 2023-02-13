package com.example.i.community.diary.diaryT

import retrofit2.Call
import retrofit2.http.GET

interface DiaryRetrofitInterface {
    @GET("/feeds/diary/all")
    fun getDiaryList(): Call<DiaryResponse>
}