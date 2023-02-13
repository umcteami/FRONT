package com.example.i.community.talk.models.talkroom

import com.google.gson.annotations.SerializedName

data class ViewTalkroomList(
    @SerializedName("boardType")val boardType: Int,
    @SerializedName("roomType") val roomType: Int, //수사방, 질문방, 정보방
    @SerializedName("feedIdx") val feedIdx: Int,
    @SerializedName("memIdx") val memIdx: Int,
    @SerializedName("memNick") val memNick: String,
    @SerializedName("memProfile") val memProfile: String,
    @SerializedName("title") val title: String,
    @SerializedName("content") val content: String,
    @SerializedName("hit") val hit: Int,
    @SerializedName("commentCnt") val commentCnt : Int,
    @SerializedName("createAt") val createAt: String,
    @SerializedName("islike") val islike : Int,
    //@SerializedName("img") val img: ArrayList<String>

)
