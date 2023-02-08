package com.example.i.community.talk.models

import com.example.i.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class FeedsWriteResponse(
    @SerializedName("result") val result : ResultFeedsWrite
):BaseResponse()
