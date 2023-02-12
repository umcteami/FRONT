package com.example.i.mypage.data.want

import com.example.i.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class WantResponse(
        @SerializedName("result") val result: ArrayList<WantRequest>,
        @SerializedName("size") val size: Int
): BaseResponse() // 베이스 리스폰스를 상속 받음
