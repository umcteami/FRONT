package com.example.i.market.model

import android.provider.MediaStore.Images
import com.google.gson.annotations.SerializedName
import java.io.File

data class PostMarketWriteRequest(
    @SerializedName("userIdx") val userIdx : Int,
    @SerializedName("title") val title : String,
    @SerializedName("category") val category : String,
    @SerializedName("price") val price : Int,
    @SerializedName("content") val content : String,
)
