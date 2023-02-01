package com.example.i.signup.models

import com.example.i.config.BaseResponse
import com.example.i.login.models.ResultLogin
import com.google.gson.annotations.SerializedName

data class EmailResponse(
        @SerializedName("result") val result: ResultEmail
): BaseResponse() // 베이스 리스폰스를 상속 받음
