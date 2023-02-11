package com.example.i.home

import com.example.i.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewTtlService(val ViewTtlInterface: ViewTtlInterface) {
    fun tryGetViewTtl(){
        val ViewTtlRetrofitInterface = ApplicationClass.sRetrofit.create(ViewTtlRetrofitInterface::class.java)
        ViewTtlRetrofitInterface.getViewTtl().enqueue(object: Callback<ViewTtlResponse>{
            override fun onResponse(
                call: Call<ViewTtlResponse>,
                response: Response<ViewTtlResponse>
            ) {
                (response.body())?.let {
                    ViewTtlInterface.onGetViewTtlSuccess(
                        it
                    )
                }
            }

            override fun onFailure(call: Call<ViewTtlResponse>, t: Throwable) {
                ViewTtlInterface.onGetViewTtlFailure(t.message ?: "통신 오류")
            }
        })
    }
}