package com.example.i.mypage.data

import com.example.i.config.BaseResponse

interface AskInterface {
    // 문의하기 API
    fun onPostAskSuccess(response: BaseResponse)
    fun onPostAskFailure(message: String)
}