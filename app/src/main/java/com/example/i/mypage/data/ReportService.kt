package com.example.i.mypage.data

import com.example.i.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReportService(val ReportInterface: ReportInterface) {
    // 신고한 게시글 API
    fun tryGetReport(){
        val ReportRetrofitInterface = ApplicationClass.sRetrofit.create(ReportRetrofitInterface::class.java)
        ReportRetrofitInterface.getReport().enqueue(object : Callback<ReportResponse>{
            override fun onResponse(call: Call<ReportResponse>, response: Response<ReportResponse>) {
                (response.body() as ReportResponse?)?.let {
                    ReportInterface.onGetReportSuccess(
                        it
                    )
                }
            }

            override fun onFailure(call: Call<ReportResponse>, t: Throwable) {
                ReportInterface.onGetReportFailure(t.message ?: "통신 오류")
            }
        })
    }
}
