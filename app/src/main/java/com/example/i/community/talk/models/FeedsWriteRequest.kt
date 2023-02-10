package com.example.i.community.talk.models

import com.google.gson.annotations.SerializedName

data class FeedsWriteRequest(
    @SerializedName("boardIdx") val boardIdx : Int,
    @SerializedName("userIdx") val userIdx : Int,
    @SerializedName("roomType") val roomType : Int,
    @SerializedName("title") val title : String,
    @SerializedName("contents") val contents : String,
    @SerializedName("imgCnt") val imgCnt : Int
)
