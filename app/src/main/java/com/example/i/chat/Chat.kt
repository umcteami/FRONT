package com.example.i.chat

data class Chat(
    val memIdx: Int,
    val sender: Int,
    val message: String,
    val chatImg: List<String>?,
    val profile: String?,
    val date_time: String?,
    val check: Boolean
)
