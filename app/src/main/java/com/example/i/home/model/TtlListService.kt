package com.example.i.home.model

import android.util.Log
import com.example.i.config.ApplicationClass
import com.example.i.home.TtlRVAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TtlListService(val TtlListInterface: TtlListInterface){
    fun tryGetTtlList() {
        val TtlListRetrofitInterface = ApplicationClass.sRetrofit.create(TtlListRetrofitInterface::class.java)
        TtlListRetrofitInterface.getTtlList().enqueue(object : Callback<TtlListResponse> {
            override fun onResponse( call: Call<TtlListResponse>, response: Response<TtlListResponse>) {
                    response.body()?.let {
                        it
                    }
            }

            override fun onFailure(call: Call<TtlListResponse>, t: Throwable) {
                TtlListInterface.onGetTtlListFailure(t.message ?: "통신 오류")
            }

        })
    }
}



