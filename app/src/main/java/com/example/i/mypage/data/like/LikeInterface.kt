package com.example.i.mypage.data.like

import com.example.i.mypage.data.want.WantResponse

interface LikeInterface {
    // 좋아요 게시글 API
    fun onGetWantSuccess(response: WantResponse)
    fun onGetWantFailure(message: String)
}