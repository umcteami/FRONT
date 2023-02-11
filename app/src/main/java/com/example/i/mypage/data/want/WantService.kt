package com.example.i.mypage.data.want

import com.example.i.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WantService(val WantInterface: WantInterface) {
    // 찜한 물품들 API
    fun tryGetWant(memIdx:Int, page: Int){
        val WantRetrofitInterface = ApplicationClass.sRetrofit.create(WantRetrofitInterface::class.java)
        WantRetrofitInterface.getWant(memIdx, page).enqueue(object : Callback<WantResponse>{
            override fun onResponse(call: Call<WantResponse>, response: Response<WantResponse>) {
                (response.body() as WantResponse?)?.let {
                    WantInterface.onGetWantSuccess(
                        it
                    )
                }
            }

            override fun onFailure(call: Call<WantResponse>, t: Throwable) {
                WantInterface.onGetWantFailure(t.message ?: "통신 오류")
            }
        })
    }
}
