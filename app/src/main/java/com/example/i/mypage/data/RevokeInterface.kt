package com.example.i.mypage.data

import com.example.i.config.BaseResponse

interface RevokeInterface {
    // 탈퇴하기 API
    fun onPostRevokeSuccess(response: BaseResponse)
    fun onPostRevokeFailure(message: String)
}