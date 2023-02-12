package com.example.i.chat.model

import com.example.i.config.ApplicationClass
import com.example.i.config.BaseResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChatOutService(val ChatDeleteInterface: ChatDeleteInterface) {
    // 채팅방 나가기 API
    fun tryPostChatOut(body: ChatDeleteRequest) {
        val ChatOutRetrofitInterface = ApplicationClass.sRetrofit.create(ChatOutRetrofitInterface::class.java)
        ChatOutRetrofitInterface.postChatOut(body).enqueue(object: Callback<BaseResponse> {
            override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                (response.body() as BaseResponse?)?.let {
                    ChatDeleteInterface.onPostChatDeleteSuccess(
                        it
                    )
                }
            }

            override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                ChatDeleteInterface.onPostChatDeleteFailure(t.message ?: "통신 오류")
            }

        })
    }
}