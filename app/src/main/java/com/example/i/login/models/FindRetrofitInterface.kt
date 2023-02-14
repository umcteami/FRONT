package com.example.i.login.models

import com.example.i.signup.models.CodeResponse
import com.example.i.signup.models.PostCodeRequest
import retrofit2.Call
import retrofit2.http.*

interface FindRetrofitInterface {
    // 인증번호 발송 API (전화번호)
    @POST("/member/join/auth")
    fun postPhone(
        @Body params: PostCodeRequest,
        @Query("find") find: Int
    ): Call<CodeResponse>

    // 이메일 찾기 API
    @GET("/member/find/email")
    fun getFind(
        @Query("phone") phone: String
    ): Call<FindResponse>
}
