package com.example.i.mypage.data
import com.google.gson.annotations.SerializedName

data class BlockRequest(
        @SerializedName("blockMemIdx") val blockMemIdx: Int,
        @SerializedName("profile") val profile: String,
        @SerializedName("nick") val nick: String,
        @SerializedName("intro") val intro: String
)