package com.example.i.chat.model

import com.example.i.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class ChatListResponse(
    @SerializedName("result") val result: ResultChatList
): BaseResponse()
