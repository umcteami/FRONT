package com.example.i.community.models

import com.google.gson.annotations.SerializedName

data class ResultHomeSearch(
    @SerializedName("boardType") val boardType : Int,
    @SerializedName("roomType") val roomType : Int,
    @SerializedName("feedIdx") val feedIdx : Int,
    @SerializedName("memIdx") val memIdx : Int,
    @SerializedName("memNick") val memNick : String,
    @SerializedName("title") val title : String,
    @SerializedName("img") val img : String,
    @SerializedName("hit") val hit : Int,
    @SerializedName("commentCnt") val commentCnt : Int,
    @SerializedName("createAt") val createAt : String
)
