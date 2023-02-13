package com.example.i.community.diary.model

import com.example.i.community.talk.models.talk.TalkResponse
import com.example.i.community.talk.models.talk.TalkRetrofitInterface
import com.example.i.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//class DiaryDService (val DiaryDInterface: DiaryDInterface) {
//    fun tryGetDiaryD(){
//        val TalkRetrofitInterface = ApplicationClass.sRetrofit.create(TalkRetrofitInterface::class.java)
//        TalkRetrofitInterface.getTalk(boardType, roomType).enqueue(object : Callback<TalkResponse> {
//            override fun onResponse(call: Call<TalkResponse>, response: Response<TalkResponse>) {
//                (response.body() as TalkResponse?)?.let {
//                    TalkInterface.onGetTalkSuccess(
//                        it
//
//                    )
//                }
//            }
//
//
//            override fun onFailure(call: Call<TalkResponse>, t: Throwable) {
//                TalkInterface.onGetTalkFailure(t.message ?: "통신 오류")
//            }
//        })
//    }
//}