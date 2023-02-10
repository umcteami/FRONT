package com.example.i.mypage.data

import com.google.gson.annotations.SerializedName

data class PostAskRequest(
        @SerializedName("title") val title: String,
        @SerializedName("content") val content: String,
        @SerializedName("email") val email: String
)