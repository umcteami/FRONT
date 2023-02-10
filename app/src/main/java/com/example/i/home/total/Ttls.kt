package com.example.i.home.total

import com.example.i.home.HasImage
import com.google.gson.annotations.SerializedName

data class Ttls(
    @SerializedName("boardType")val boardType: Int,
    @SerializedName("roomType") val roomType: Int,
    @SerializedName("feedIdx") val feedIdx: Int,
    @SerializedName("memIdx") val memIdx: Int,
    @SerializedName("memNick") val memNick: String,
    @SerializedName("title") val title: String,
    @SerializedName("img") val img: String,
    @SerializedName("hit") val hit: Int,
    @SerializedName("commentCnt") val commentCnt : Int,
    @SerializedName("createAt") val createAt: String,
    val hasImage: HasImage
)



