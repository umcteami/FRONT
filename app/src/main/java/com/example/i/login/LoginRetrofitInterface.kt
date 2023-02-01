package com.example.i.login

import com.example.i.login.models.PostLoginRequest
import com.example.i.login.models.SignUpResponse
import retrofit2.Call
import retrofit2.http.*

interface LoginRetrofitInterface {
    @POST("/member/login")
    fun postSignUp(@Body params: PostLoginRequest): Call<SignUpResponse>
}
