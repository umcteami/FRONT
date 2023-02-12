package com.example.i.mypage.data.want

interface WantInterface {
    // 찜한 물품들 API
    fun onGetWantSuccess(response: WantResponse)
    fun onGetWantFailure(message: String)
}