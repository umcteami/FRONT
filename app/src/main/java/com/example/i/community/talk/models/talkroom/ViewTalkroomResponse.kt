package com.example.i.community.talk.models.talkroom

import com.example.i.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class ViewTalkroomResponse(
    @SerializedName("result") val result: Feed,
    @SerializedName("result") val result2: Img
):BaseResponse()
