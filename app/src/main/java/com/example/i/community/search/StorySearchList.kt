package com.example.i.community.search

import com.google.gson.annotations.SerializedName

data class StorySearchList(
    @SerializedName("boardType")val boardType: Int,
    @SerializedName("roomType") val roomType: Int, //수사방, 질문방, 정보방
    @SerializedName("feedIdx") val feedIdx: Int,
    @SerializedName("memIdx") val memIdx: Int,
    @SerializedName("memNick") val memNick: String,
    @SerializedName("title") val title: String,
    @SerializedName("img") val img: String,
    @SerializedName("hit") val hit: Int,
    @SerializedName("commentCnt") val commentCnt : Int,
    @SerializedName("likeCnt") val likeCnt : Int,
    @SerializedName("createAt") val createAt: String
    )
