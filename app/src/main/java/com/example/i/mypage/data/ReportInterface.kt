package com.example.i.mypage.data

interface ReportInterface {
    // 신고한 게시글 API
    fun onGetReportSuccess(response: ReportResponse)
    fun onGetReportFailure(message: String)
}