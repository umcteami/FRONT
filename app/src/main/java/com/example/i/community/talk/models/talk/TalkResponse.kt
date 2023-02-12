package com.example.i.community.talk.models.talk

import com.example.i.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class TalkResponse(
    @SerializedName("result") val result: ArrayList<TalkList>
):BaseResponse()
