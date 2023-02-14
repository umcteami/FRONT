package com.example.i.market.model

import com.google.gson.annotations.SerializedName

data class ResultMarketUserList(
    @SerializedName("marketIdx") val marketIdx: Int,
    @SerializedName("userIdx") val userIdx: Int,
    @SerializedName("userNickname") val userNick: String,
    @SerializedName("group") val group: String,
    @SerializedName("title") val title: String,
    @SerializedName("content") val content: String,
    @SerializedName("price") val price: Int,
    @SerializedName("image") val img: String,
    @SerializedName("soldout") val soldout: String,
    @SerializedName("likeCount") val likeCnt: Int,
    @SerializedName("hit") val hit: Int,
    @SerializedName("createdAt") val creatTime: String,
    @SerializedName("userLiked") val liked: Boolean
)
