package com.example.i.community.models

import com.example.i.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LikeChangeService(val LikeChangeInterface: LikeChangeInterface) {
    fun tryPostLikeChange(body: RequestLikeChange) {
        val LikeChangeRetrofitInterface = ApplicationClass.sRetrofit.create(LikeChangeRetrofitInterface::class.java)
        LikeChangeRetrofitInterface.postLikeChange(body).enqueue(object:
            Callback<LikeChangeResponse> {
            override fun onResponse(
                call: Call<LikeChangeResponse>,
                response: Response<LikeChangeResponse>
            ) {
                (response.body() as LikeChangeResponse?)?.let {
                    LikeChangeInterface.onPostChangeLikeSuccess(
                        it
                    )
                }
            }

            override fun onFailure(call: Call<LikeChangeResponse>, t: Throwable) {
                LikeChangeInterface.onPostChangeLikeFailure(t.message ?: "통신 오류")
            }

        })
    }
}