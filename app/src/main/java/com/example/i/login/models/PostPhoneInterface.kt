package com.example.i.login.models

import com.example.i.signup.models.CodeResponse

interface PostPhoneInterface {

    // 전화번호 인증번호 발송
    fun onPostPhoneSuccess(response: CodeResponse)
    fun onPostPhoneFailure(message: String)
}