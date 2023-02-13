package com.example.i.mypage.data

import retrofit2.Call
import retrofit2.http.*

interface ReportRetrofitInterface {
    // 신고한 게시글 API
    @GET("/mypage/blame/{memIdx}")
    fun getReport(
        @Path("memIdx") memIdx: Int
    ): Call<ReportResponse>
}
