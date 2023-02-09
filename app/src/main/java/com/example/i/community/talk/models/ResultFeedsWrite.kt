package com.example.i.community.talk.models

import com.google.gson.annotations.SerializedName

data class ResultFeedsWrite(
    @SerializedName("boardIdx") val boardIdx : Int,
    @SerializedName("feedsIdx") val feedsIdx : Int
)
