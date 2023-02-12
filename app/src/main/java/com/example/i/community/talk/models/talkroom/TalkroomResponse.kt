package com.example.i.community.talk.models.talkroom

import com.example.i.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class TalkroomResponse(
    @SerializedName("result") val result: ArrayList<TalkroomList>
):BaseResponse()
