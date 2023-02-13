package com.example.i.community.search

import com.example.i.config.ApplicationClass
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class MarketSearchService (val MarketSearchInterface : MarketSearchInterface, val category : String?, val searchKeyword : String, val page : Int?, val searchTarget : String, val userIdx : Int){
    fun tryGetMarketSearch(){
        val MarketSearchRetrofitInterface = ApplicationClass.sRetrofit.create(MarketSearchRetrofitInterface::class.java)
        MarketSearchRetrofitInterface.getMarketSearch(category,searchKeyword,page,searchTarget, params = MarketSearchRequest(userIdx)).enqueue(object:
        Callback<MarketSearchResponse> {
            override fun onResponse(
                call: Call<MarketSearchResponse>,
                response: Response<MarketSearchResponse>
            ) {
                (response.body() as MarketSearchResponse?)?.let {
                    MarketSearchInterface.onGetMarketSearchSuccess(
                        it
                    )
                }
            }

            override fun onFailure(call: Call<MarketSearchResponse>, t: Throwable) {
                MarketSearchInterface.onGetMarketSearchFailure(t.message ?: "통신 오류")
            }
        }
            )
    }
}