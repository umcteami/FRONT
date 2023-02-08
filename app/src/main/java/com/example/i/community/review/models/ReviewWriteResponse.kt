package com.example.i.community.review.models

import com.example.i.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class ReviewWriteResponse(
//    var isSuccess : Boolean,
//    var code : Int,
//    var message : String,
//    var resultIdx : Int
@SerializedName("result") val result : ResultReviewWrite
): BaseResponse()
