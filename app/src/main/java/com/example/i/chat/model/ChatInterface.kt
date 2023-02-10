package com.example.i.chat.model

interface ChatInterface {

    fun onGetChatSuccess(response: ChatListResponse)

    fun onGetChatFailure(message: String)
}