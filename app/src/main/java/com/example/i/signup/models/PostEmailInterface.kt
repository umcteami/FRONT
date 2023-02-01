package com.example.i.signup.models

interface PostEmailInterface {

    // 이메일 인증번호 발송
    fun onPostEmailSuccess(response: CodeResponse)
    fun onPostEmailFailure(message: String)
}