package com.example.i.community.talk.models

import com.example.i.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class FeedsDeleteResponse(
    @SerializedName("result") val result : String
) : BaseResponse()
