package com.example.i.community.models

import com.example.i.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class CommentResponse(
    @SerializedName("result") val result: ArrayList<ResultComment>
): BaseResponse()
