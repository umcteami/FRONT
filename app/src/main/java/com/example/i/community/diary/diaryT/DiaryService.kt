package com.example.i.community.diary.diaryT

import com.example.i.config.ApplicationClass
import com.example.i.home.model.TtlListInterface
import com.example.i.home.model.TtlListResponse
import com.example.i.home.model.TtlListRetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DiaryService(val DiaryInterface: DiaryInterface){
    fun tryGetDiaryList(){
        val DiaryRetrofitInterface = ApplicationClass.sRetrofit.create(DiaryRetrofitInterface::class.java)
        DiaryRetrofitInterface.getDiaryList().enqueue(object : Callback<DiaryResponse> {
            override fun onResponse(call: Call<DiaryResponse>, response: Response<DiaryResponse>) {
                (response.body() as DiaryResponse?)?.let {
                    DiaryInterface.onGetDiaryListSuccess(
                        it

                    )
                }
            }


            override fun onFailure(call: Call<DiaryResponse>, t: Throwable) {
                DiaryInterface.onGetDiaryListFailure(t.message ?: "통신 오류")
            }
        })
    }
}