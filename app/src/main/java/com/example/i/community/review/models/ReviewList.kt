package com.example.i.community.review.models

import com.google.gson.annotations.SerializedName

data class ReviewList(

    @SerializedName("reviewIdx") val reviewIdx: Int,
    @SerializedName("buyerIdx") val memIdx: Int,
    @SerializedName("sellerIdx") val memProfile: Int,
    @SerializedName("buyerNick") val memNick: String,
    @SerializedName("sellerNick") val title: String,
    @SerializedName("buyerProfile") val img: String,
    @SerializedName("goods") val goods: String,
    @SerializedName("hit") val hit: Int,
    @SerializedName("commentCnt") val commentCnt : Int,
    @SerializedName("likeCnt") val likeCnt : Int,
    @SerializedName("createAt") val createAt: String,
    @SerializedName("image") val imgage: String
)
