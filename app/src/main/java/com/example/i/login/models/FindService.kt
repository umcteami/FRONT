package com.example.i.login.models

import com.example.i.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FindService(val FindInterface: FindInterface) {
    // 이메일 찾기 API
    fun tryGetFind(phone : String){
        val FindRetrofitInterface = ApplicationClass.sRetrofit.create(FindRetrofitInterface::class.java)
        FindRetrofitInterface.getFind(phone).enqueue(object : Callback<FindResponse>{
            override fun onResponse(call: Call<FindResponse>, response: Response<FindResponse>) {
                (response.body() as FindResponse?)?.let {
                    FindInterface.onGetFindSuccess(
                        it
                    )
                }
            }

            override fun onFailure(call: Call<FindResponse>, t: Throwable) {
                FindInterface.onGetFindFailure(t.message ?: "통신 오류")
            }
        })
    }
}
