package com.example.i.mypage.data.mymarket

import com.example.i.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MarketService(val MarketInterface: MarketInterface) {
    // 나눔장터 작성 글 조회 API
    fun tryGetMarket(memIdx:Int, page: Int){
        val MarketRetrofitInterface = ApplicationClass.sRetrofit.create(MarketRetrofitInterface::class.java)
        MarketRetrofitInterface.getMarket(memIdx, page).enqueue(object : Callback<MarketResponse>{
            override fun onResponse(call: Call<MarketResponse>, response: Response<MarketResponse>) {
                (response.body() as MarketResponse?)?.let {
                    MarketInterface.onGetMarketSuccess(
                        it
                    )
                }
            }

            override fun onFailure(call: Call<MarketResponse>, t: Throwable) {
                MarketInterface.onGetMarketFailure(t.message ?: "통신 오류")
            }
        })
    }
}
