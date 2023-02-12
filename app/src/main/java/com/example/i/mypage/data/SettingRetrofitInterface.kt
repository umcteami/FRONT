package com.example.i.mypage.data

import com.example.i.chat.model.ChatListResponse
import retrofit2.Call
import retrofit2.http.*

interface SettingRetrofitInterface {
    // 회원정보 조회 API
    @GET("/member/{memIdx}")
    fun getUser(@Path("memIdx") memIdx: Int): Call<userSearchgResponse>

    // 회원정보 수정 API
    @PATCH("/member/33")
    fun postSetting(@Body params: SettingRequest): Call<SettingResponse>
}
