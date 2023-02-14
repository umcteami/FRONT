package com.example.i.market.model

import com.example.i.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MarketListService (val MarketListInterface: MarketListInterface){
    fun tryGetMarketList(userIdx: Int){
        val MarketListRetrofitInterface = ApplicationClass.sRetrofit.create(MarketListRetrofitInterface::class.java)
        MarketListRetrofitInterface.getMarketList(userIdx).enqueue(object : Callback<MarketListResponse>{
            override fun onResponse( call: Call<MarketListResponse>, response: Response<MarketListResponse>) {
                (response.body()as MarketListResponse?)?.let {
                    MarketListInterface.onGetMarketListSuccess(
                        it

                    )
                }
            }

            override fun onFailure(call: Call<MarketListResponse>, t: Throwable) {
                MarketListInterface.onGetMarketListFailure(t.message ?: "통신 오류")
            }
        })
    }
}