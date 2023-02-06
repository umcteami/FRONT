package com.example.i.mypage.data

import com.example.i.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SettingService(val SettingInterface: SettingInterface) {

    fun tryPatchSetting(SettingRequest: SettingRequest){
        val SettingRetrofitInterface = ApplicationClass.sRetrofit.create(SettingRetrofitInterface::class.java)
        SettingRetrofitInterface.postSetting(SettingRequest).enqueue(object : Callback<SettingResponse>{
            override fun onResponse(call: Call<SettingResponse>, response: Response<SettingResponse>) {
                (response.body() as SettingResponse?)?.let {
                    SettingInterface.onPatchSettingSuccess(
                        it
                    )
                }
            }

            override fun onFailure(call: Call<SettingResponse>, t: Throwable) {
                SettingInterface.onPatchSettingFailure(t.message ?: "통신 오류")
            }
        })
    }

}
