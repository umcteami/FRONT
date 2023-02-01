package com.example.i.signup.models

import com.google.gson.annotations.SerializedName

data class EmailCheckResponse(
        @SerializedName("isSuccess") val isSuccess: Boolean = false,
        @SerializedName("code") val code: Int = 0,
        @SerializedName("message") val message: String? = null,
        @SerializedName("result") val result: ResultCheckEmail
)
