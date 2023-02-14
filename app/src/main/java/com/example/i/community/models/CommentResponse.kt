package com.example.i.community.models

import com.google.gson.annotations.SerializedName

data class CommentResponse(
    @SerializedName("result") val result: ArrayList<ResultComment>
)
