package com.example.i.mypage.data

import retrofit2.Call
import retrofit2.http.*

interface ReportRetrofitInterface {
    // 신고한 게시글 API
    @GET("/mypage/blame/33")
    fun getReport(): Call<ReportResponse>
}
