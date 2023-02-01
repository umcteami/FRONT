package com.example.i.signup.models

import com.google.gson.annotations.SerializedName

data class PostCodeRequest(
        @SerializedName("type") val type: Int,
        @SerializedName("auth") val auth: String
)