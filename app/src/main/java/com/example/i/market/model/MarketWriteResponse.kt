package com.example.i.market.model

import com.example.i.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class MarketWriteResponse(
    @SerializedName("result") val result : ResultMarketWrite
):BaseResponse()
