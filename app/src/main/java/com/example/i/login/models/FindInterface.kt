package com.example.i.login.models

interface FindInterface {
    // 이메일 찾기 API
    fun onGetFindSuccess(response: FindResponse)
    fun onGetFindFailure(message: String)
}