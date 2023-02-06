package com.example.i.mypage.data

interface SettingInterface {

    fun onPatchSettingSuccess(response: SettingResponse)

    fun onPatchSettingFailure(message: String)
}