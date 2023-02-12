package com.example.i.signup.models

import com.google.gson.annotations.SerializedName

data class PostSignUpRequest(
        @SerializedName("email") val email: String,
        @SerializedName("pw") val pw: String,
        @SerializedName("phone") val phone: String,
        @SerializedName("nick") val nick: String,
        @SerializedName("intro") val intro: String,
        @SerializedName("birth") val birth: String,
        @SerializedName("adresCode") val adresCode: String,
        @SerializedName("adres") val adres: String,
        @SerializedName("adresPlus") val adresPlus: String
//        @SerializedName("profile") val profile: String
)