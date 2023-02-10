package com.example.i.signup.models

import com.example.i.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class EmailCheckResponse(
        @SerializedName("result") val result: ResultCheckEmail
): BaseResponse()
