package com.example.i.community.talk.models

import com.google.gson.annotations.SerializedName

data class PatchFeedsEditRequest(
    @SerializedName("boardIdx") val boardIdx : Int,
    @SerializedName("userIdx") val userIdx : Int,
    @SerializedName("roomType") val roomType : Int,
    @SerializedName("title") val title : String,
    @SerializedName("content") val content : String,
    @SerializedName("feedIdx") val feedIdx : Int
)
