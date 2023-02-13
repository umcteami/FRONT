package com.example.i.community.talk.models

import com.google.gson.annotations.SerializedName
import java.io.File
import java.nio.file.Files

data class PostFeedsWriteImageRequest(
    @SerializedName("userIdx") val userIdx : Int,
    @SerializedName("boardIdx") val boardIdx : Int,
    @SerializedName("roomType") val roomType : Int,
    @SerializedName("title") val title : String,
    @SerializedName("content") val content : String
    )
