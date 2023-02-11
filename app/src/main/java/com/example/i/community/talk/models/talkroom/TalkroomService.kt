package com.example.i.community.talk.models.talkroom

import com.example.i.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class TalkroomService (val TalkroomInterface: TalkroomInterface){
    fun tryGetTalkroom(page:Int){
        val TalkroomRetrofitInterface = ApplicationClass.sRetrofit.create(TalkroomRetrofitInterface::class.java)
        TalkroomRetrofitInterface.getTalkroom(page).enqueue(object :Callback<TalkroomResponse>{
            override fun onResponse( call: Call<TalkroomResponse>,  response: Response<TalkroomResponse>) {
                response.body()?.let {
                    it
                }
            }

            override fun onFailure(call: Call<TalkroomResponse>, t: Throwable) {
                TalkroomInterface.onGetTalkroomFailure(t.message?: "통신오류")
            }
        })
    }
}