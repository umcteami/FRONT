package com.example.i.signup.models

import retrofit2.Call
import retrofit2.http.*

interface SignUpRetrofitInterface {

    // 인증번호 발송 API (메일)
    @POST("/member/join/auth")
    fun postEmail(@Body params: PostCodeRequest): Call<CodeResponse>

    // 인증번호 발송 API (전화번호)
    @POST("/member/join/auth")
    fun postPhone(@Body params: PostCodeRequest): Call<CodeResponse>

    // 인증번호 조회 API
    @GET("/member/join/auth")
    fun getEmail(@Query("ma_idx") ma_idx: Int): Call<EmailCheckResponse>
}
