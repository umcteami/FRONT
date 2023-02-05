package com.example.i.mypage.data

import com.example.i.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class SettingResponse(
        @SerializedName("result") val result: String
): BaseResponse() // 베이스 리스폰스를 상속 받음
