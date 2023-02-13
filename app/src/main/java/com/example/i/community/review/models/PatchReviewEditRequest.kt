package com.example.i.community.review.models

import com.google.gson.annotations.SerializedName

data class PatchReviewEditRequest(
    @SerializedName("sellerIdx") val sellerIdx : Int,
    @SerializedName("buyerIdx") val buyerIdx : Int,
    @SerializedName("goods") val goods : String,
    @SerializedName("content") val content : String,
    @SerializedName("imgCnt") val imgCnt : Int,
)
