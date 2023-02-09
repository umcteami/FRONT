package com.example.i.mypage.data

import retrofit2.Call
import retrofit2.http.*

interface SettingRetrofitInterface {
    // 회원정보 조회 API
    @GET("/member/33")
    fun getUser(): Call<userSearchgResponse>

    // 회원정보 수정 API
    @PATCH("/member/33")
    fun postSetting(@Body params: SettingRequest): Call<SettingResponse>
}
