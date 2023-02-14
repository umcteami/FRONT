package com.example.i.market.model

import com.example.i.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MarketUserListService(val MarketUserListInterface: MarketUserListInterface) {
    // 나눔장터 판매자별 판매글 조회 API
    fun tryGetMarketUserList(userIdx: Int) {
        val MarketUserListRetroInterface = ApplicationClass.sRetrofit.create(MarketUserListRetroInterface::class.java)
        MarketUserListRetroInterface.getMarketUserList(userIdx).enqueue(object: Callback<MarketUserListResponse> {
            override fun onResponse(
                call: Call<MarketUserListResponse>,
                response: Response<MarketUserListResponse>
            ) {
                (response.body() as MarketUserListResponse?)?.let {
                    MarketUserListInterface.onGetMarketUserListSuccess(
                        it
                    )
                }
            }

            override fun onFailure(call: Call<MarketUserListResponse>, t: Throwable) {
                MarketUserListInterface.onGetChatListFailure(t.message ?: "통신 오류")
            }

        })
    }
}