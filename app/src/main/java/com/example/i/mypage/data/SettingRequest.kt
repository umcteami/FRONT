package com.example.i.mypage.data

import com.google.gson.annotations.SerializedName
import okhttp3.MultipartBody

data class SettingRequest(
        @SerializedName("email") val email: String,
        @SerializedName("phone") val phone: String,
        @SerializedName("nick") val nick: String,
        @SerializedName("intro") val intro: String,
        @SerializedName("birth") val birth: String,
        @SerializedName("addresCode") val addresCode: String,
        @SerializedName("addres") val addres: String,
        @SerializedName("addresPlus") val addresPlus: String,
        //@SerializedName("profile") val profile: String
)