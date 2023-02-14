package com.example.i.community.talk.models.talkroom

import com.google.gson.annotations.SerializedName

data class ViewTalkroomList(
    @SerializedName("boardType")val boardType: Int? = null,
    @SerializedName("roomType") val roomType: Int? = null, //수사방, 질문방, 정보방
    @SerializedName("feedIdx") val feedIdx: Int? = null,
    @SerializedName("memIdx") val memIdx: Int? = null,
    @SerializedName("memNick") val memNick: String? = null,
    @SerializedName("memProfile") val memProfile: String? = null,
    @SerializedName("title") val title: String? = null,
    @SerializedName("content") val content: String? = null,
    @SerializedName("hit") val hit: Int? = null,
    @SerializedName("commentCnt") val commentCnt : Int? = null,
    @SerializedName("createAt") val createAt: String? = null,
    @SerializedName("islike") val islike : Int? = null,
    //@SerializedName("img") val img: ArrayList<String>

    @SerializedName("img") val img: ArrayList<String>

)
