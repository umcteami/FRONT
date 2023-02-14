package com.example.i.mypage.data

import com.google.gson.annotations.SerializedName

data class SettingRequest(
        @SerializedName("email") val email: String? = null,
        @SerializedName("phone") val phone: String? = null,
        @SerializedName("nick") val nick: String? = null,
        @SerializedName("intro") val intro: String? = null,
        @SerializedName("birth") val birth: String? = null,
        @SerializedName("addresCode") val addresCode: String? = null,
        @SerializedName("addres") val addres: String? = null,
        @SerializedName("addresPlus") val addresPlus: String? = null,
        @SerializedName("profile") val profile: String? = null
)