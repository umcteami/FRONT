package com.example.i.home.total

import com.example.i.config.BaseResponse

import com.google.gson.annotations.SerializedName

data class ViewTotalResponse(
    @SerializedName("result") val result: Total1Data
):BaseResponse()

