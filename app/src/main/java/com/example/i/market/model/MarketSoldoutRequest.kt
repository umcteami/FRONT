package com.example.i.market.model

import com.google.gson.annotations.SerializedName

data class MarketSoldoutRequest(
    @SerializedName("soldout") val soldout : String,
    @SerializedName("userIdx") val userIdx : Int
)
