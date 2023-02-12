package com.example.i.community.talk.models

import com.google.gson.annotations.SerializedName
import java.io.File
import java.nio.file.Files

data class PostFeedsWriteImageRequest(
    val userIdx : Int,
    val boardIdx : Int,
    val roomType : Int,
    val title : String,
    val content : String,
    val imgCnt : Int
)
