package com.example.i.community.review.models

import com.google.gson.annotations.SerializedName

data class PostReviewWriteRequest(
    @SerializedName("sellerIdx") val sellerIdx : Int,
    @SerializedName("buyerIdx") val buyerIdx : Int,
    @SerializedName("goods") val goods : String,
    @SerializedName("content") val content : String,
    @SerializedName("imgCnt") val imgCnt : Int,
//    @SerializedName("img") val img : File
//    @Override
//    public String toString() {
//    return "PostResult{" +
//            "userId=" + userId +
//            ", id=" + id +
//            ", title='" + title + '\'' +
//            ", bodyValue='" + bodyValue + '\'' +
//            '}';
//}


)
