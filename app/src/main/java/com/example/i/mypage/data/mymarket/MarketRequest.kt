package com.example.i.mypage.data.mymarket
import com.google.gson.annotations.SerializedName

data class MarketRequest(
        @SerializedName("boarIdx") val boarIdx: Int? = null,
        @SerializedName("comuIdx") val comuIdx: Int? = null,
        @SerializedName("title") val title: String? = null,
        @SerializedName("feedImg") val feedImg: String? = null,
        @SerializedName("soldout") val soldout: Int? = null,
        @SerializedName("countReserve") val countReserve: Int? = null
)