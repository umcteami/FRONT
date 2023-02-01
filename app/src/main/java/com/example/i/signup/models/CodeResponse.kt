package com.example.i.signup.models

import com.example.i.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class CodeResponse(
        @SerializedName("result") val result: ResultCode
): BaseResponse() // 베이스 리스폰스를 상속 받음
