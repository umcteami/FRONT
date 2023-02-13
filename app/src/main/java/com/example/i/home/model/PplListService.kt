package com.example.i.home.model

import com.example.i.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class PplListService (val PplListInterface: PplListInterface) {
    fun tryGetPplList(){
        val PplListRetrofitInterface = ApplicationClass.sRetrofit.create(PplListRetrofitInterface::class.java)
        PplListRetrofitInterface.getPplList().enqueue(object : Callback<PplListResponse>{
            override fun onResponse( call: Call<PplListResponse>, response: Response<PplListResponse>) {
                (response.body()as PplListResponse?)?.let {
                    PplListInterface.onGetPplListSuccess(
                        it
                    )
                }
            }

            override fun onFailure(call: Call<PplListResponse>, t: Throwable) {
                PplListInterface.onGetPplListFailure(t.message ?: "통신 오류")
            }
        })
    }
}