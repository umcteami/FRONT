package com.example.i.market.model

import com.google.gson.annotations.SerializedName

data class ResultMarketWrite(
    @SerializedName("userIdx") val userIdx : Int,
    @SerializedName("marketIdx") val marketIdx : Int,
    @SerializedName("isLike") val isLike : String?
)
