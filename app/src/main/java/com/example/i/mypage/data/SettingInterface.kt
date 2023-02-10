package com.example.i.mypage.data

interface SettingInterface {
    // 회원정보 조회 API
    fun onGetUserSuccess(response: userSearchgResponse)
    fun onGetuserFailure(message: String)

    // 회원정보 수정 API
    fun onPatchSettingSuccess(response: SettingResponse)
    fun onPatchSettingFailure(message: String)
}