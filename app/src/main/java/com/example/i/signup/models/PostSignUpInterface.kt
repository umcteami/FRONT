package com.example.i.signup.models

import com.example.i.config.BaseResponse

interface PostSignUpInterface {
    // 회원가입 API
    fun onPostSignUpSuccess(response: BaseResponse)
    fun onPostSignUpFailure(message: String)
}