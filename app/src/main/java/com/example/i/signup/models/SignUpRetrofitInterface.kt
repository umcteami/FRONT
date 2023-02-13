package com.example.i.signup.models

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface SignUpRetrofitInterface {
    // 회원가입 API
    @Multipart
    @POST("/member/join")
    fun postJoin(
//        @Body params: PostSignUpRequest,
        @Part("request") request : RequestBody,
        @Part profile : MultipartBody.Part?
    ): Call<SignUpResponse>
}
