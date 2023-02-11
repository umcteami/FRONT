package com.example.i.mypage.data.like


interface LikeInterface {
    // 좋아요한 게시글 API
    fun onGetLikeSuccess(response: LikeResponse)
    fun onGetLikeFailure(message: String)
}