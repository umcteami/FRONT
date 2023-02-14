package com.example.i.community.search

import com.google.gson.annotations.SerializedName

data class MarketSearchRequest(
    @SerializedName("userIdx")val userIdx : Int
)
