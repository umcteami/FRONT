package com.example.i.signup.models

import com.google.gson.annotations.SerializedName

data class PostSignUpRequest(
        @SerializedName("email") val email: String? = null,
        @SerializedName("pw") val pw: String? = null,
        @SerializedName("phone") val phone: String? = null,
        @SerializedName("nick") val nick: String? = null,
        @SerializedName("intro") val intro: String? = null,
        @SerializedName("birth") val birth: String? = null,
        @SerializedName("adresCode") val adresCode: String? = null,
        @SerializedName("adres") val adres: String? = null,
        @SerializedName("adresPlus") val adresPlus: String? = null,
)