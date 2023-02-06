package com.example.i.mypage.data

import retrofit2.Call
import retrofit2.http.*

interface SettingRetrofitInterface {
    @PATCH("/member/{memIdx}")
    fun postSetting(@Body params: SettingRequest): Call<SettingResponse>
}
