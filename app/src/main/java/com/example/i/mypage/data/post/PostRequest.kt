package com.example.i.mypage.data.post
import com.google.gson.annotations.SerializedName

data class PostRequest(
        @SerializedName("boardIdx") val boardIdx: Int? = null,
        @SerializedName("roomType") val roomType: Int? = null,
        @SerializedName("comuIdx") val comuIdx: Int? = null,
        @SerializedName("title") val title: String? = null,
        @SerializedName("feedImg") val feedImg: String? = null,
        @SerializedName("hit") val hit: Int? = null,
        @SerializedName("countLike") val countLike: Int? = null,
        @SerializedName("countComment") val countComment: Int? = null,
        @SerializedName("createAt") val createAt: String? = null
)