package com.example.i.market.model

import com.example.i.community.talk.models.FeedsWriteInterface
import com.example.i.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MarketWriteService (val MarketWriteInterface : MarketWriteInterface){
    fun tryPostMarketWrite(PostMarketWriteRequest : PostMarketWriteRequest){
        val marketWriteRetrofitInterface = ApplicationClass.sRetrofit.create(
            MarketWriteRetrofitInterface::class.java)
        marketWriteRetrofitInterface.postMarketWrite(PostMarketWriteRequest).enqueue(object :
            Callback<MarketWriteResponse>
        {
            override fun onResponse(
                call: Call<MarketWriteResponse>,
                response: Response<MarketWriteResponse>
            ) {
                (response.body() as MarketWriteResponse)?.let{
                    MarketWriteInterface.onPostMarketWriteSuccess(
                        it
                    )
                }
            }

            override fun onFailure(call: Call<MarketWriteResponse>, t: Throwable) {
                MarketWriteInterface.onPostMarketWriteFailure(t.message?:"오류")
            }
        }
        )

    }
}