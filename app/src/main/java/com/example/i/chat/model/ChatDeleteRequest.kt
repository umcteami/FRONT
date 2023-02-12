package com.example.i.chat.model

import com.google.gson.annotations.SerializedName

data class ChatDeleteRequest(
    @SerializedName ("roomIdx") val roomIdx: Int,
    @SerializedName ("memIdx") val memIdx: Int
)
