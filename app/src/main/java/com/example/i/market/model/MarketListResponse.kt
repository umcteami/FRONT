package com.example.i.market.model

import com.example.i.config.BaseResponse
import com.example.i.home.model.TtlList
import com.google.gson.annotations.SerializedName

data class MarketListResponse(
    @SerializedName("result") val result: ArrayList<MarketList>
):BaseResponse()
