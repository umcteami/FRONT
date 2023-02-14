package com.example.i.community.talk.models.talkroom

import com.example.i.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class PplTalkroomService (val PplTalkroomInterface: PplTalkroomInterface){
    fun tryGetPplTalkroom(boardType:String, filter:Int,page:Int){
        val PplTalkroomRetrofitInterface = ApplicationClass.sRetrofit.create(PplTalkroomRetrofitInterface::class.java)
        PplTalkroomRetrofitInterface.getPplTalkroom(boardType,filter,page).enqueue(object : Callback<PplTalkroomResponse>{
            override fun onResponse( call: Call<PplTalkroomResponse>, response: Response<PplTalkroomResponse>) {
                (response.body()as PplTalkroomResponse?)?.let {
                    PplTalkroomInterface.onGetPplTalkroomSuccess(
                        it
                    )
                }
            }

            override fun onFailure(call: Call<PplTalkroomResponse>, t: Throwable) {
                PplTalkroomInterface.onGetPplTalkroomFailure(t.message ?: "통신 오류")
            }
        })
    }
}