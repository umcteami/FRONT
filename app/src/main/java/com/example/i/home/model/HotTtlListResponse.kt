package com.example.i.home.model

import com.example.i.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class HotTtlListResponse(

    @SerializedName("result") val result: ArrayList<HotTtlList>
):BaseResponse()
