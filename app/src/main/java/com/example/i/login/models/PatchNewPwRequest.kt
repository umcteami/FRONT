package com.example.i.login.models

import com.google.gson.annotations.SerializedName

data class PatchNewPwRequest(
        @SerializedName("pw") val pw: String,
)