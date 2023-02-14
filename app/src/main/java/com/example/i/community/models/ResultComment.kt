package com.example.i.community.models

import com.google.gson.annotations.SerializedName

data class ResultComment(
    @SerializedName("commentIdx") val commentIdx: Int,
    @SerializedName("boardIdx") val boardIdx: Int,
    @SerializedName("feedIdx") val feedIdx: Int,
    @SerializedName("parentIdx") val parentIdx: Int,
    @SerializedName("memIdx") val memIdx: Int,
    @SerializedName("nickname") val nick: String,
    @SerializedName("comment") val comment: String,
    @SerializedName("createAt") val time: String
)
