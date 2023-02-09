package com.example.i.mypage.data

interface MyPageInterface {
    // 마이페이지 시작창 조회 API
    fun onGetMyPageSuccess(response: MyPageResponse)
    fun onGetMyPageFailure(message: String)
}