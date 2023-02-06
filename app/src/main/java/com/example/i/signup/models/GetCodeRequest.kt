package com.example.i.signup.models

import com.google.gson.annotations.SerializedName

data class GetCodeRequest(
        @SerializedName("ma_idx") val ma_idx: Int
)