package com.example.i.signup.models

import retrofit2.Call
import retrofit2.http.*

interface SignUpRetrofitInterface {

    // 인증번호 발송 API
    @POST("/member/join/auth")
    fun postEmail(@Body params: PostEmailRequest): Call<EmailResponse>

    // 인증번호 조회 API
    @GET("/member/join/auth")
    fun getEmail(): Call<EmailCheckResponse>
}
