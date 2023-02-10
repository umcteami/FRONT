package com.example.i.mypage.data

import com.example.i.config.ApplicationClass
import com.example.i.config.BaseResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AskService(val AskInterface: AskInterface) {
    // 문의하기 API
    fun tryPostAsk(PostAskRequest: PostAskRequest){
        val AskRetrofitInterface = ApplicationClass.sRetrofit.create(AskRetrofitInterface::class.java)
        AskRetrofitInterface.postAsk(PostAskRequest).enqueue(object : Callback<BaseResponse>{
            override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                (response.body() as BaseResponse?)?.let {
                    AskInterface.onPostAskSuccess(
                        it
                    )
                }
            }

            override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                AskInterface.onPostAskFailure(t.message ?: "통신 오류")
            }
        })
    }
}
