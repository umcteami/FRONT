package com.example.i.login

import com.example.i.config.ApplicationClass
import com.example.i.login.models.PostLoginRequest
import com.example.i.login.models.LoginResponse
import com.example.i.login.models.NewPwResponse
import com.example.i.login.models.PatchNewPwRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewPwService(val NewPwInterface: NewPwInterface) {

    fun tryPatchNewPw(PatchNewPwRequest: PatchNewPwRequest){
        val NewPwRetrofitInterface = ApplicationClass.sRetrofit.create(NewPwRetrofitInterface::class.java)
        NewPwRetrofitInterface.patchNewPw(PatchNewPwRequest).enqueue(object : Callback<NewPwResponse>{
            override fun onResponse(call: Call<NewPwResponse>, response: Response<NewPwResponse>) {
                (response.body() as NewPwResponse?)?.let {
                    NewPwInterface.onPatchNewPwSuccess(
                        it
                    )
                }
            }

            override fun onFailure(call: Call<NewPwResponse>, t: Throwable) {
                NewPwInterface.onPatchNewPwFailure(t.message ?: "통신 오류")
            }
        })
    }

}
