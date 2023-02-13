package com.example.i.market.model

import com.example.i.community.talk.models.FeedsWriteInterface
import com.example.i.config.ApplicationClass
import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MarketWriteService (val MarketWriteInterface : MarketWriteInterface){
    fun tryPostMarketWrite(PostMarketWriteRequest : PostMarketWriteRequest, images : List<MultipartBody.Part?>){
        val marketWriteRetrofitInterface = ApplicationClass.sRetrofit.create(
            MarketWriteRetrofitInterface::class.java)
        val requestBody = Gson().toJson(PostMarketWriteRequest)
            .toRequestBody("application/json; charest=utf-8".toMediaTypeOrNull())
        marketWriteRetrofitInterface.postMarketWrite(requestBody, images).enqueue(object :
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