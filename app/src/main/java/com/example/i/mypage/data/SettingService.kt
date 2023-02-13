package com.example.i.mypage.data

import com.example.i.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SettingService(val SettingInterface: SettingInterface) {

    // 회원정보 조회 API
    fun tryGetUser(memIdx:Int){
        val SettingRetrofitInterface = ApplicationClass.sRetrofit.create(SettingRetrofitInterface::class.java)
        SettingRetrofitInterface.getUser(memIdx).enqueue(object : Callback<userSearchgResponse>{
            override fun onResponse(call: Call<userSearchgResponse>, response: Response<userSearchgResponse>) {
                (response.body() as userSearchgResponse?)?.let {
                    SettingInterface.onGetUserSuccess(
                        it
                    )
                }
            }

            override fun onFailure(call: Call<userSearchgResponse>, t: Throwable) {
                SettingInterface.onGetuserFailure(t.message ?: "통신 오류")
            }
        })
    }

    // 회원정보 수정 API
    fun tryPatchSetting(memIdx: Int, SettingRequest: SettingRequest){
        val SettingRetrofitInterface = ApplicationClass.sRetrofit.create(SettingRetrofitInterface::class.java)
        SettingRetrofitInterface.postSetting(memIdx, SettingRequest).enqueue(object : Callback<SettingResponse>{
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
