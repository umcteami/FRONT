package com.example.i.market.model

import com.google.gson.annotations.SerializedName

data class MarketUserListResult(
    @SerializedName("marketIdx") val marketId: Int,
    @SerializedName("userIdx") val userIdx: Int,
    @SerializedName("userNickname") val nick: String,
    @SerializedName("group") val group: Int,
    @SerializedName("title") val title: String,
    @SerializedName("content") val content: String,
    @SerializedName("price") val price: Int,
    @SerializedName("image") val img: String,
    @SerializedName("soldout") val soldout: Int,
    @SerializedName("likeCount") val likeCnt: Int,
    @SerializedName("hit") val hit: Int,
    @SerializedName("createdAt") val time: String,
    @SerializedName("userLiked") val liked: Boolean
)
