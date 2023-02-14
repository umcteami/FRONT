package com.example.i.community.review.models

import com.example.i.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class ReviewListResponse(
    @SerializedName("result") val result: ArrayList<ReviewList>
):BaseResponse()
