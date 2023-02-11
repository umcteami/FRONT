package com.example.i.mypage.data.post

import com.example.i.config.BaseResponse
import com.example.i.mypage.data.like.LikeRequest
import com.google.gson.annotations.SerializedName

data class PostResponse(
        @SerializedName("result") val result: ArrayList<LikeRequest>,
        @SerializedName("size") val size: Int
): BaseResponse() // 베이스 리스폰스를 상속 받음
