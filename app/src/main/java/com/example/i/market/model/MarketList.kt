package com.example.i.market.model

import com.google.gson.annotations.SerializedName

data class MarketList(
    @SerializedName("marketIdx") val feedIdx: Int,
    @SerializedName("userIdx") val memIdx: Int,
    @SerializedName("userNickname") val memNick: String,
    @SerializedName("group") val group: Int,
    @SerializedName("title") val title: String,
    @SerializedName("content") val content: String? = null,
    @SerializedName("price") val price: Int,
    @SerializedName("img") val img: String,
    @SerializedName("soldout") val soldout: String? = null,
    @SerializedName("hit") val hit: Int,
    @SerializedName("likeCnt") val likeCnt : Int,
    @SerializedName("createAt") val createAt: String,
    @SerializedName("userLiked") val userLiked: Boolean
)
