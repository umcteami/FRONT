package com.example.i.signup.models

import com.google.gson.annotations.SerializedName

data class PostEmailRequest(
        @SerializedName("type") val type: Int,
        @SerializedName("auth") val auth: String
)