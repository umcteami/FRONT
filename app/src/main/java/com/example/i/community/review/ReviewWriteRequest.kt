package com.example.i.community.review

import com.google.gson.annotations.SerializedName
import java.io.File

data class ReviewWriteRequest(
    @SerializedName("sellerIdx") val sellerIdx : Int,
    @SerializedName("buyerIdx") val buyerIdx : Int,
    @SerializedName("goods") val goods : String,
    @SerializedName("content") val content : String,
    @SerializedName("imgCnt") val imgCnt : Int,
    @SerializedName("img") val img : File
)
