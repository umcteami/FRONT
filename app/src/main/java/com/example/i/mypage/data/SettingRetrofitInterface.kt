package com.example.i.mypage.data

import retrofit2.Call
import retrofit2.http.*

interface SettingRetrofitInterface {
    @PATCH("/member/30")
    fun postSetting(@Body params: SettingRequest): Call<SettingResponse>
}
