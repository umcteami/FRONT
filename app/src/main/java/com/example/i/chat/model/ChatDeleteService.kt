package com.example.i.chat.model

import com.example.i.config.ApplicationClass
import com.example.i.config.BaseResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChatDeleteService(val ChatDeleteInterface: ChatDeleteInterface) {
    // 채팅 삭제 API
    fun tryPostChatDelete(body: ChatDeleteRequest) {
        val ChatDeleteRetrofitInterface = ApplicationClass.sRetrofit.create(ChatDeleteRetrofitInterface::class.java)
        ChatDeleteRetrofitInterface.postChatDelete(body).enqueue(object: Callback<BaseResponse> {
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