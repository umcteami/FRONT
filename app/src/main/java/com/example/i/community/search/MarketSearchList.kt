package com.example.i.community.search

import com.google.gson.annotations.SerializedName

data class MarketSearchList(
    @SerializedName("marketIdx")val marketIdx : Int,
    @SerializedName("userIdx")val userIdx : Int,
    @SerializedName("userNickname")val userNickname : String?,
    @SerializedName("userProfileUrl")val userProfileUrl : String?,
    @SerializedName("category")val category : Int,
    @SerializedName("title")val title : String,
    @SerializedName("content")val content : String?,
    @SerializedName("price")val price : Int,
    @SerializedName("image")val image : String,
    @SerializedName("soldout")val soldout : String,
    @SerializedName("likeCount")val likeCount : Int,
    @SerializedName("hit")val hit : Int,
    @SerializedName("createdAt")val createdAt : String,
    @SerializedName("userLiked")val userLiked : Boolean
)
