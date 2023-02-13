package com.example.i.community.diary.diaryT

import com.example.i.home.model.TtlListResponse

interface DiaryInterface {

    fun onGetDiaryListSuccess(response: DiaryResponse)
    fun onGetDiaryListFailure(message: String)
}