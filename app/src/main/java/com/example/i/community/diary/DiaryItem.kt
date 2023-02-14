package com.example.i.community.diary

import com.example.i.home.HasImage

data class DiaryItem(
    val hasImage: HasImage,
    val roomType: String,
    val title : String,
    val writer : String,
    val memImg : String,
    val date : String,
    val view : String,
    val content : String,
    val Img : String?,
    val heart : String,
    val comment : String
)