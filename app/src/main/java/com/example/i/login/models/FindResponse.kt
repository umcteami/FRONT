package com.example.i.login.models

import com.example.i.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class FindResponse(
        @SerializedName("result") val result: String
): BaseResponse() // 베이스 리스폰스를 상속 받음
