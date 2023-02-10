package com.example.i.chat.model

import com.google.gson.annotations.SerializedName

data class ResultChatList(
    @SerializedName("romeIdx") val roomIdx: Int,
    @SerializedName("sender") val sender: Int,
    @SerializedName("profile") val profile: String,
    @SerializedName("nick") val nick: String,
    @SerializedName("recentChat") val recentChat: String,
    @SerializedName("recentTime") val recentTime: String,
    @SerializedName("noReadNum") val noReadNum: Int
)
