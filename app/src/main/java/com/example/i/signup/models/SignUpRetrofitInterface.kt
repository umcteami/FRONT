package com.example.i.signup.models

import retrofit2.Call
import retrofit2.http.*

interface SignUpRetrofitInterface {
    // 회원가입 API
    @POST("/member/join")
    fun postJoin(@Body params: PostSignUpRequest): Call<SignUpResponse>
}
