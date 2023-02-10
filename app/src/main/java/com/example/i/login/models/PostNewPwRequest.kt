package com.example.i.login.models

import com.google.gson.annotations.SerializedName

data class PostNewPwRequest(
        @SerializedName("email") val email: String,
        @SerializedName("pw") val pw: String
)