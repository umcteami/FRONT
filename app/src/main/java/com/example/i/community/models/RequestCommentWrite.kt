package com.example.i.community.models

import com.google.gson.annotations.SerializedName

data class RequestCommentWrite(
    @SerializedName("memIdx") val memIdx: Int,
    @SerializedName("boardType") val boardType: Int,
    @SerializedName("feedIdx") val feedIdx: Int,
    @SerializedName("comment") val comment: String,
    @SerializedName("parentCmt") val parentCmt: Int
)
