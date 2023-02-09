package com.example.i.community.talk.models

import com.example.i.community.review.models.PostReviewWriteRequest
import com.example.i.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class FeedsWriteService (val FeedsWriteInterface : FeedsWriteInterface){
    fun tryPostFeedsWrite(PostFeedsWriteRequest : PostFeedsWriteRequest){
        val feedsWriteRetrofitInterface = ApplicationClass.sRetrofit.create(
            FeedsWriteRetrofitInterface::class.java)
        feedsWriteRetrofitInterface.postFeedsWrite(PostFeedsWriteRequest).enqueue(object :
            Callback<FeedsWriteResponse> {
            override fun onResponse(
                call: Call<FeedsWriteResponse>,
                response: Response<FeedsWriteResponse>
            ) {
                (response.body() as FeedsWriteResponse?)?.let{
                    FeedsWriteInterface.onPostFeedsWriteSuccess(
                        it
                    )
                }
            }

            override fun onFailure(call: Call<FeedsWriteResponse>, t: Throwable) {
                FeedsWriteInterface.onPostFeedsWriteFailure(t.message ?: "오류")
            }
        })

    }
}