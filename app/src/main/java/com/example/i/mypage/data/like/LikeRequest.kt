package com.example.i.mypage.data.like
import com.google.gson.annotations.SerializedName

data class LikeRequest(
        @SerializedName("boardIdx") val boardIdx: Int? = null,
        @SerializedName("comuIdx") val comuIdx: Int? = null,
        @SerializedName("image") val image: String? = null,
        @SerializedName("price") val price: Int? = null,
        @SerializedName("title") val title: String? = null,
        @SerializedName("createAt") val createAt: String? = null,
        @SerializedName("hits") val hits: Int? = null,
        @SerializedName("wantCount") val wantCount: Int? = null,
        @SerializedName("soldout") val soldout: Boolean? = null
)