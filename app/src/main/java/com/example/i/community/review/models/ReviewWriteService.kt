package com.example.i.community.review.models

import com.example.i.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReviewWriteService(val ReviewWriteInterface : ReviewWriteInterface) {
    fun tryPostReviewWrite(PostReviewWriteRequest : PostReviewWriteRequest){
        val reviewWriteRetrofitInterface = ApplicationClass.sRetrofit.create(
            ReviewWriteRetrofitInterface::class.java)
        reviewWriteRetrofitInterface.postReviewWrite(PostReviewWriteRequest).enqueue(object :
            Callback<ReviewWriteResponse>{
            override fun onResponse(
                call: Call<ReviewWriteResponse>,
                response: Response<ReviewWriteResponse>
            ) {
                (response.body() as ReviewWriteResponse?)?.let {
                    ReviewWriteInterface.onPostReviewWriteSuccess(
                        it
                    )
                }
            }
            override fun onFailure(call: Call<ReviewWriteResponse>, t: Throwable) {
                ReviewWriteInterface.onPostReviewWriteFailure(t.message ?: "통신 오류")
            }
            })
    }
}