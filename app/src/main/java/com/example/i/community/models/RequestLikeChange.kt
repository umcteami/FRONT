package com.example.i.community.models

import com.google.gson.annotations.SerializedName

data class RequestLikeChange(
    @SerializedName("memIdx") val memIdx: Int,
    @SerializedName("boardType") val boardType: Int,
    @SerializedName("feedIdx") val feedIdx: Int
)
