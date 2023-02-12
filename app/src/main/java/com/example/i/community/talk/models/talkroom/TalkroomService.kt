package com.example.i.community.talk.models.talkroom

import com.example.i.config.ApplicationClass
import com.example.i.home.model.TtlListInterface
import com.example.i.home.model.TtlListResponse
import com.example.i.home.model.TtlListRetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class TalkroomService(val TalkroomInterface: TalkroomInterface){
    fun tryGetTalkroom(){
        val TalkroomRetrofitInterface = ApplicationClass.sRetrofit.create(TalkroomRetrofitInterface::class.java)
        TalkroomRetrofitInterface.getTalkroom().enqueue(object : Callback<TalkroomResponse>{
            override fun onResponse(call: Call<TalkroomResponse>, response: Response<TalkroomResponse>) {
                (response.body() as TalkroomResponse?)?.let {
                    TalkroomInterface.onGetTalkroomSuccess(
                        it

                    )
                }
            }

            override fun onFailure(call: Call<TalkroomResponse>, t: Throwable) {
                TalkroomInterface.onGetTalkroomFailure(t.message ?: "통신 오류")
            }
        })
    }
}
