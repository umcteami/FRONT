package com.example.i.community.models

import com.example.i.config.ApplicationClass
import com.example.i.config.BaseResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LikeChangeService(val LikeChangeInterface: LikeChangeInterface) {
    fun tryPostLikeChange(body: RequestLikeChange) {
        val LikeChangeRetrofitInterface = ApplicationClass.sRetrofit.create(LikeChangeRetrofitInterface::class.java)
        LikeChangeRetrofitInterface.postLikeChange(body).enqueue(object:
            Callback<BaseResponse> {
            override fun onResponse(
                call: Call<BaseResponse>,
                response: Response<BaseResponse>
            ) {
                (response.body() as BaseResponse?)?.let {
                    LikeChangeInterface.onPostChangeLikeSuccess(
                        it
                    )
                }
            }

            override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                LikeChangeInterface.onPostChangeLikeFailure(t.message ?: "통신 오류")
            }

        })
    }
}