package com.example.i.chat.model

interface ChatListInterface {

    fun onGetChatListSuccess(response: ChatListResponse)

    fun onGetChatListFailure(message: String)
}