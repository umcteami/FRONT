package com.example.i.signup.models

import com.google.gson.annotations.SerializedName

data class ResultCheckEmail(
        @SerializedName("auth") val auth : String
)