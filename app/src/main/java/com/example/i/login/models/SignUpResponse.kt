package com.example.i.login.models

import com.google.gson.annotations.SerializedName

data class SignUpResponse(
        @SerializedName("isSuccess") val isSuccess: Boolean = false,
        @SerializedName("code") val code: Int = 0,
        @SerializedName("message") val message: String? = null,
        @SerializedName("result") val result: ResultLogin
)
