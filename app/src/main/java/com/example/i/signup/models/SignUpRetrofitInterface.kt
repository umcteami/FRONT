package com.example.i.signup.models

import com.example.i.login.models.PostLoginRequest
import com.example.i.login.models.LoginResponse
import retrofit2.Call
import retrofit2.http.*

interface SignUpRetrofitInterface {
    @POST("/member/join/auth")
    fun postEmail(@Body params: PostEmailRequest): Call<EmailResponse>

    @POST("/member/login")
    fun postSignUp(@Body params: PostSignUpRequest): Call<SignUpResponse>
}
