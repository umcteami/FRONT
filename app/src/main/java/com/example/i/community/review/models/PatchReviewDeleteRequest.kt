package com.example.i.community.review.models

import com.google.gson.annotations.SerializedName

data class PatchReviewDeleteRequest(
    @SerializedName("reviewIdx") val reviewIdx : Int
)
