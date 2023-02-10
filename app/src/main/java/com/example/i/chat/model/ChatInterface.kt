package com.example.i.chat.model

interface ChatInterface {

    fun onGetChatSuccess(response: ChatResponse)

    fun onGetChatFailure(message: String)
}