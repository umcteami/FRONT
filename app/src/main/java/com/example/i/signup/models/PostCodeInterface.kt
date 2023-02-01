package com.example.i.signup.models

interface PostCodeInterface {

    // 이메일 인증번호 발송
    fun onPostEmailSuccess(response: CodeResponse)
    fun onPostEmailFailure(message: String)

    // 전화번호 인증번호 발송
    fun onPostPhoneSuccess(response: CodeResponse)
    fun onPostPhoneFailure(message: String)
}