package com.example.i.login.models
import com.google.gson.annotations.SerializedName

data class FindRequest(
        @SerializedName("email") val email: String
)