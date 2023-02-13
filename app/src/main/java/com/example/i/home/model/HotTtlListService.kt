package com.example.i.home.model

import com.example.i.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HotTtlListService(val HotTtlListInterface: HotTtlListInterface){
    fun tryGetHotTtlList(){
        val HotTtlListRetrofitInterface = ApplicationClass.sRetrofit.create(HotTtlListRetrofitInterface::class.java)
        HotTtlListRetrofitInterface.getHotTtlList().enqueue(object : Callback<HotTtlListResponse>{
            override fun onResponse(call: Call<HotTtlListResponse>, response: Response<HotTtlListResponse>) {
                (response.body() as HotTtlListResponse?)?.let {
                    HotTtlListInterface.onGetHotTtlListSuccess(
                        it
                    )
                }
            }


            override fun onFailure(call: Call<HotTtlListResponse>, t: Throwable) {
                HotTtlListInterface.onGetHotTtlListFailure(t.message?: "통신오류")
            }
        })
    }
}

