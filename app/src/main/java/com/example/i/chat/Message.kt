package com.example.i.chat

import retrofit2.http.Url

data class Message(
    val profile: String,
    val nickname: String,
    val chat: String,
    val time: String,
    val num: String
)
