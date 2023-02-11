package com.example.i.community.review.models

import com.example.i.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReviewDeleteService (val ReviewDeleteInterface : ReviewDeleteInterface) {
    fun tryPatchReviewDelete(PatchReviewDeleteRequest : PatchReviewDeleteRequest){
        val reviewDeleteRetrofitInterface = ApplicationClass.sRetrofit.create(
            ReviewDeleteRetrofitInterface::class.java)
        reviewDeleteRetrofitInterface.patchReviewDelete(PatchReviewDeleteRequest).enqueue(object :
            Callback<ReviewDeleteResponse> {
            override fun onResponse(
                call: Call<ReviewDeleteResponse>,
                response: Response<ReviewDeleteResponse>
            ) {
                (response.body() as ReviewDeleteResponse?)?.let{
                    ReviewDeleteInterface.onPatchReviewDeleteSuccess(
                        it
                    )
                }
            }

            override fun onFailure(call: Call<ReviewDeleteResponse>, t: Throwable) {
                ReviewDeleteInterface.onPatchReviewDeleteFailure(t.message ?: "통신 오류")
            }
        }
        )
    }
}