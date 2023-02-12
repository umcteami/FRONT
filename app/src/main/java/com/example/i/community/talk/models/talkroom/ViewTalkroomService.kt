package com.example.i.community.talk.models.talkroom

import com.example.i.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewTalkroomService (val ViewTalkroomInterface: ViewTalkroomInterface){
    fun tryGetViewTalkroom(storyInx: Int, memInx: Int){
        val ViewTalkroomRetrofitInterface = ApplicationClass.sRetrofit.create(ViewTalkroomRetrofitInterface::class.java)
        ViewTalkroomRetrofitInterface.getViewTalkroom(storyInx, memInx).enqueue(object : Callback<ViewTalkroomResponse> {
            override fun onResponse(call: Call<ViewTalkroomResponse>, response: Response<ViewTalkroomResponse>) {
                (response.body() as ViewTalkroomResponse?)?.let {
                    ViewTalkroomInterface.onGetViewTalkroomSuccess(
                        it

                    )
                }
            }

            override fun onFailure(call: Call<ViewTalkroomResponse>, t: Throwable) {
                ViewTalkroomInterface.onGetViewTalkroomFailure(t.message ?: "통신 오류")
            }
        })
    }
}