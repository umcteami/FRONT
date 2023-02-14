package com.example.i.mypage.data

import com.example.i.config.ApplicationClass
import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
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
    fun tryPatchSetting(memIdx: Int, SettingEditRequest: SettingEditRequest){
        val requestBody = Gson().toJson(SettingEditRequest)
            .toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())
        val emptyImage = RequestBody.create("image/jpeg".toMediaTypeOrNull(), ByteArray(0))
        val image = MultipartBody.Part.createFormData("profile","profile.jpg",emptyImage)

        val SettingRetrofitInterface = ApplicationClass.sRetrofit.create(SettingRetrofitInterface::class.java)
        SettingRetrofitInterface.postSetting(memIdx, requestBody, image).enqueue(object : Callback<SettingResponse>{
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
