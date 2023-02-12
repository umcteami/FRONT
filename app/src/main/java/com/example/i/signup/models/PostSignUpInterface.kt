package com.example.i.signup.models

interface PostSignUpInterface {
    // 회원가입 API
    fun onPostSignUpSuccess(response: SignUpResponse)
    fun onPostSignUpFailure(message: String)
}