package com.example.i.signup.models

import com.example.i.config.BaseResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface SignUpRetrofitInterface {
    // 회원가입 API
    @Multipart
    @POST("/member/join")
    fun postJoin(
        @Part("request") request : PostSignUpRequest,
        @Part profile : MultipartBody.Part? = null
    ): Call<BaseResponse>
}
