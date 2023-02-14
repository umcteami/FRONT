package com.example.i.community.search

import com.example.i.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BestKeywordService (val BestKeywordInterface : BestKeywordInterface){
    fun tryGetBestKeyword(){
        val BestKeywordRetrofitInterface = ApplicationClass.sRetrofit.create(BestKeywordRetrofitInterface::class.java)
        BestKeywordRetrofitInterface.getBestKeyword().enqueue(object:
            Callback<BestKeywordResponse>{
            override fun onResponse(
                call: Call<BestKeywordResponse>,
                response: Response<BestKeywordResponse>
            ) {
                (response.body() as BestKeywordResponse?)?.let{
                    BestKeywordInterface.onGetBestKeywordSuccess(
                        it
                    )
                }
            }

            override fun onFailure(call: Call<BestKeywordResponse>, t: Throwable) {
                BestKeywordInterface.onGetBestKeywordFailure(t.message?:"통신 오류")
            }
            })
    }
}