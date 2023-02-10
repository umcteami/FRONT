package com.example.i.mypage.data

import com.example.i.config.BaseResponse
import com.example.i.login.models.ResultLogin
import com.google.gson.annotations.SerializedName

data class userSearchgResponse(
        @SerializedName("result") val result: SettingRequest
): BaseResponse() // 베이스 리스폰스를 상속 받음
