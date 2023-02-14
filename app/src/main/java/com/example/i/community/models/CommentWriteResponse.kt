package com.example.i.community.models

import com.google.gson.annotations.SerializedName

data class CommentWriteResponse(
    @SerializedName("result") val result: ArrayList<String>
)
