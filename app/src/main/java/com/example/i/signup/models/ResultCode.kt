package com.example.i.signup.models

import com.google.gson.annotations.SerializedName

data class ResultCode(
        @SerializedName("authIdx") val auth : Int
)