package com.example.i.mypage.data.post

import com.example.i.mypage.data.like.LikeResponse

interface PostInterface {
    // 작성 글 조회 API
    fun onGetPostSuccess(response: LikeResponse)
    fun onGetPostFailure(message: String)
}