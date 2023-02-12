package com.example.i.mypage.data.mymarket

import com.example.i.config.BaseResponse
import com.example.i.mypage.data.like.LikeRequest
import com.example.i.mypage.data.post.PostRequest
import com.google.gson.annotations.SerializedName

data class MarketResponse(
        @SerializedName("result") val result: ArrayList<MarketRequest>,
        @SerializedName("size") val size: Int
): BaseResponse() // 베이스 리스폰스를 상속 받음
