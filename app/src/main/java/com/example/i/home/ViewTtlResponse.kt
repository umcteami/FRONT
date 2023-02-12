package com.example.i.home

import com.example.i.config.BaseResponse
import com.example.i.home.Ttls

import com.google.gson.annotations.SerializedName

data class ViewTtlResponse(
    @SerializedName("result") val result: Ttls
):BaseResponse()

