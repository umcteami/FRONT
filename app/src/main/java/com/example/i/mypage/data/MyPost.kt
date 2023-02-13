package com.example.i.mypage.data

import com.example.i.home.HasImage

data class MyPost(
    var profile : String? = null,
    var img : String? = null,
    val tag: String,
    val content: String,
    val time: String,
    val view: String,
    val num: String
)

