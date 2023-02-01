package com.example.i.login.models

import com.google.gson.annotations.SerializedName

data class ResultLogin(
        @SerializedName("id") val id : Int,
        @SerializedName("email") val email : String,
        @SerializedName("nickname") val nickname : String,
        @SerializedName("accessToken") val accessToken : String,
        @SerializedName("refreshToken") val refreshToken : String
)