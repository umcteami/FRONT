package com.example.i.mypage.data
import com.google.gson.annotations.SerializedName

data class ReportRequest(
        @SerializedName("roomType") val roomType: Int,
        @SerializedName("profile") val profile: String,
        @SerializedName("nick") val nick: String,
        @SerializedName("createAt") val createAt: String
)