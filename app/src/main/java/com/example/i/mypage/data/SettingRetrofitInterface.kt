package com.example.i.mypage.data

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface SettingRetrofitInterface {
    // 회원정보 조회 API
    @GET("/member/{memIdx}")
    fun getUser(@Path("memIdx") memIdx: Int): Call<userSearchgResponse>

    // 회원정보 수정 API
    @Multipart
    @PATCH("/member/{memIdx}")
    fun postSetting(
        @Path("memIdx") memIdx: Int,
        @Part("request") request : RequestBody,
        @Part profile : MultipartBody.Part?
    ): Call<SettingResponse>
}
