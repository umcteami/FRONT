package com.example.i.market.model

import com.google.gson.annotations.SerializedName

data class MarketUserListRequest(
    @SerializedName("userIdx") val authIdx: Int
)
