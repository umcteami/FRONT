package com.example.i.community.review.models

import com.example.i.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReviewListService (val ReviewListInterface: ReviewListInterface){
    fun tryGetReviewList(){
        val ReviewListRetrofitInterface = ApplicationClass.sRetrofit.create(ReviewListRetrofitInterface::class.java)
        ReviewListRetrofitInterface.getReviewList().enqueue(object : Callback<ReviewListResponse>{
            override fun onResponse(call: Call<ReviewListResponse>, response: Response<ReviewListResponse>) {
                (response.body() as ReviewListResponse?)?.let {
                    ReviewListInterface.onGetReviewListSuccess(
                        it
                    )
                }
            }

            override fun onFailure(call: Call<ReviewListResponse>, t: Throwable) {
                ReviewListInterface.onGetReviewListFailure(t.message ?:"통신 오류")
            }
        })
    }

}