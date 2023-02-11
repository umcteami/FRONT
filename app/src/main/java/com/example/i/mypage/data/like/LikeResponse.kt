package com.example.i.mypage.data.like

import com.example.i.config.BaseResponse
import com.example.i.mypage.data.want.WantRequest
import com.google.gson.annotations.SerializedName

data class LikeResponse(
    @SerializedName("result") val result: ArrayList<WantRequest>,
    @SerializedName("size") val size: Int
): BaseResponse() // 베이스 리스폰스를 상속 받음
