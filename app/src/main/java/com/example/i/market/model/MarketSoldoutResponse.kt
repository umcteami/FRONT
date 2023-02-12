package com.example.i.market.model

import com.example.i.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class MarketSoldoutResponse(
    @SerializedName("result") val result : String?
) : BaseResponse()
