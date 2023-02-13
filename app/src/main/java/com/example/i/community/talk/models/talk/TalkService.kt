package com.example.i.community.talk.models.talk



import com.example.i.community.talk.models.talkroom.TalkroomResponse
import com.example.i.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TalkService(val TalkInterface: TalkInterface) {
    fun tryGetTalk(roomType: Int){
        val TalkRetrofitInterface = ApplicationClass.sRetrofit.create(TalkRetrofitInterface::class.java)
        TalkRetrofitInterface.getTalk(roomType).enqueue(object : Callback<TalkResponse>{
            override fun onResponse(call: Call<TalkResponse>, response: Response<TalkResponse>) {
                (response.body() as TalkResponse?)?.let {
                    TalkInterface.onGetTalkSuccess(
                        it

                    )
                }
            }


            override fun onFailure(call: Call<TalkResponse>, t: Throwable) {
                TalkInterface.onGetTalkFailure(t.message ?: "통신 오류")
            }
        })
    }
}



