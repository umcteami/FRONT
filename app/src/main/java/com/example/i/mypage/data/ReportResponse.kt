package com.example.i.mypage.data

import com.example.i.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class ReportResponse(
        @SerializedName("result") val result: ArrayList<ReportRequest>
): BaseResponse() // 베이스 리스폰스를 상속 받음
