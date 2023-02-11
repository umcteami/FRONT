package com.example.i.signup.models

interface GetEmailInterface {
    // 이메일 인증번호 확인
    fun onGetEmailSuccess(response: EmailCheckResponse)
    fun onGetEmailFailure(message: String)
}