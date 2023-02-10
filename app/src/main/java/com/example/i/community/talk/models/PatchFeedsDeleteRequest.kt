package com.example.i.community.talk.models

import com.google.gson.annotations.SerializedName

data class PatchFeedsDeleteRequest(
    @SerializedName("boardType") val boardType : Int,
    @SerializedName("feedsIdx") val feedsIdx : Int
)
