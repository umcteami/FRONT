package com.example.i.community.search

import com.example.i.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class StorySearchResponse(
    @SerializedName("result") val result : ArrayList<StorySearchList>
) : BaseResponse()
