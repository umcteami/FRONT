package com.example.i.chat.model

import com.google.gson.annotations.SerializedName

data class ResultChat(
    @SerializedName("sender") val sender: Int,
    @SerializedName("message") val message: String,
    @SerializedName("chatImg") val chatImg: List<String>,
    @SerializedName("chatTime") val chatTime: String,
    @SerializedName("senderProfile") val senderProfile: String,
    @SerializedName("senderNick") val senderNick: String
)
