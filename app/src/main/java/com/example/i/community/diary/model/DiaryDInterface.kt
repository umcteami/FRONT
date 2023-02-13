package com.example.i.community.diary.model

interface DiaryDInterface {
    fun onGetDiaryDSuccess(response: DiaryDResponse)
    fun onGetDiaryDFailure(message: String)
}