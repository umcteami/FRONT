package com.example.i.mypage.data

import retrofit2.Call
import retrofit2.http.*

interface SettingRetrofitInterface {
    // 회원정보 수정 API
    @PATCH("/member/30")
    fun postSetting(@Body params: SettingRequest): Call<SettingResponse>

    // 회원정보 조회 API
    @GET("/member/30")
    fun getUser(@Query("memIdx") memIdx: Int): Call<userSearchgResponse>
}
