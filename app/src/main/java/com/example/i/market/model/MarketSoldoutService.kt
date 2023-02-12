package com.example.i.market.model

import com.example.i.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MarketSoldoutService (val MarketSoldoutInterface : MarketSoldoutInterface, private val memberIdx : Int) {
    fun tryPutMarketSoldout(MarketSoldoutRequest : MarketSoldoutRequest){
        val marketSoldoutRetrofitInterface = ApplicationClass.sRetrofit.create(
            MarketSoldoutRetrofitInterface::class.java)
        marketSoldoutRetrofitInterface.putMarketSoldout(MarketSoldoutRequest, memberIdx).enqueue(object :
            Callback<MarketSoldoutResponse>
        {
            override fun onResponse(
                call: Call<MarketSoldoutResponse>,
                response: Response<MarketSoldoutResponse>
            ) {
                (response.body() as MarketSoldoutResponse)?.let{
                    MarketSoldoutInterface.onPutMarketSoldoutSuccess(
                        it
                    )
                }
            }
            override fun onFailure(call: Call<MarketSoldoutResponse>, t: Throwable) {
                MarketSoldoutInterface.onPutMarketSoldoutFailure(t.message?:"통신 오류")
            }
        }
        )
    }
}