package com.example.i.mypage.data

import com.google.gson.annotations.SerializedName
import okhttp3.MultipartBody

data class MyPageRequest(
        @SerializedName("nick") val nick: String,
        @SerializedName("intro") val intro: String,
        @SerializedName("profile") val profile: String,
        @SerializedName("feedCount") val feedCount: Int,
        @SerializedName("diaryCount") val diaryCount: Int,
        @SerializedName("marketCount") val marketCount: Int,
        @SerializedName("alarm") val alarm: String
)