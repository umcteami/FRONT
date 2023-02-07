package com.example.i.login

import com.example.i.config.ApplicationClass
import com.example.i.config.BaseResponse
import com.example.i.login.models.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewPwService(val NewPwInterface: NewPwInterface) {

    fun tryPatchNewPw(PostNewPwRequest: PostNewPwRequest){
        val NewPwRetrofitInterface = ApplicationClass.sRetrofit.create(NewPwRetrofitInterface::class.java)
        NewPwRetrofitInterface.postNewPw(PostNewPwRequest).enqueue(object : Callback<BaseResponse>{
            override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                (response.body() as BaseResponse?)?.let {
                    NewPwInterface.onPatchNewPwSuccess(
                        it
                    )
                }
            }

            override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                NewPwInterface.onPatchNewPwFailure(t.message ?: "통신 오류")
            }
        })
    }

}
