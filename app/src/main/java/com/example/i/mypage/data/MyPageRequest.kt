package com.example.i.mypage.data

import com.google.gson.annotations.SerializedName
import okhttp3.MultipartBody

data class MyPageRequest(
        @SerializedName("nick") val nick: String? = null,
        @SerializedName("intro") val intro: String? = null,
        @SerializedName("profile") val profile: String? = null,
        @SerializedName("feedCount") val feedCount: Int = 0,
        @SerializedName("diaryCount") val diaryCount: Int = 0,
        @SerializedName("marketCount") val marketCount: Int = 0,
        @SerializedName("alarm") val alarm: String? = null
)