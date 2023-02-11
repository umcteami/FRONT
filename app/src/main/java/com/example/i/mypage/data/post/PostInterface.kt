package com.example.i.mypage.data.post

import com.example.i.mypage.data.like.LikeResponse

interface PostInterface {
    // 작성 글 조회 API
    fun onGetPostSuccess(response: PostResponse)
    fun onGetPostFailure(message: String)

    // 일기장 작성 글 조회 API
    fun onGetDiarySuccess(response: PostResponse)
    fun onGetDiaryFailure(message: String)
}