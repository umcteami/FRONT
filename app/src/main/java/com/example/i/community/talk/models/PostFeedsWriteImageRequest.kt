package com.example.i.community.talk.models

import com.google.gson.annotations.SerializedName
import java.io.File
import java.nio.file.Files

data class PostFeedsWriteImageRequest(
    @SerializedName("request") val request : FeedsWriteRequest,
    @SerializedName("image") val image: Files
)
