package com.example.i.community.search

import com.example.i.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReviewSearchService (val ReviewSearchInterface : ReviewSearchInterface, val searchKeyword: String?, val page : Int?) {
    fun trygetReviewSearch(){
        val ReviewSearchRetrofitInterface = ApplicationClass.sRetrofit.create(ReviewSearchRetrofitInterface::class.java)
        ReviewSearchRetrofitInterface.getReviewSearch(searchKeyword, page).enqueue(object :
            Callback<ReviewSearchResponse> {
            override fun onResponse(
                call: Call<ReviewSearchResponse>,
                response: Response<ReviewSearchResponse>
            ) {
                (response.body() as ReviewSearchResponse?)?.let{
                    ReviewSearchInterface.onGetReviewSearchSuccess(
                        it
                    )
                }
            }

            override fun onFailure(call: Call<ReviewSearchResponse>, t: Throwable) {
                ReviewSearchInterface.onGetReviewSearchFailure(t.message?:"통신 오류")
            }
        })
    }
}