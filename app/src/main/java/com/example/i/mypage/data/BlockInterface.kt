package com.example.i.mypage.data

interface BlockInterface {
    // 차단한 사용자 API
    fun onGetBlockSuccess(response: BlockResponse)
    fun onGetBlockFailure(message: String)
}