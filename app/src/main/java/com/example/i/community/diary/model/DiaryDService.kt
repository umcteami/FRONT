package com.example.i.community.diary.model

import com.example.i.community.talk.models.talk.TalkResponse
import com.example.i.community.talk.models.talk.TalkRetrofitInterface
import com.example.i.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DiaryDService (val DiaryDInterface: DiaryDInterface) {
    fun tryGetDiaryD(roomType:Int){
        val DiaryDRetrofitInterface = ApplicationClass.sRetrofit.create(DiaryDRetrofitInterface::class.java)
        DiaryDRetrofitInterface.getDiaryD(roomType).enqueue(object : Callback<DiaryDResponse> {
            override fun onResponse(call: Call<DiaryDResponse>, response: Response<DiaryDResponse>) {
                (response.body() as DiaryDResponse?)?.let {
                    DiaryDInterface.onGetDiaryDSuccess(
                        it

                    )
                }
            }

            override fun onFailure(call: Call<DiaryDResponse>, t: Throwable) {
                DiaryDInterface.onGetDiaryDFailure(t.message ?: "통신 오류")
            }
        })
    }
}