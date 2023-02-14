package com.example.i.market.model

import com.example.i.config.ApplicationClass
import com.example.i.mypage.data.mymarket.MarketInterface
import com.example.i.mypage.data.mymarket.MarketRetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MarketListService (val MarketListInterface: MarketListInterface){
    fun tryGetMarketList(category: String, soldout:String){
        val MarketListRetrofitInterface = ApplicationClass.sRetrofit.create(MarketListRetrofitInterface::class.java)
        MarketListRetrofitInterface.getMarketList(category,soldout).enqueue(object : Callback<MarketListResponse>{
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