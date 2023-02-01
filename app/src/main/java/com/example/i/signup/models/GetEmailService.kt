package com.example.i.signup.models

import com.example.i.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetEmailService(val GetEmailInterface: GetEmailInterface) {

    fun tryGetEmail(){
        val SignUpRetrofitInterface = ApplicationClass.sRetrofit.create(SignUpRetrofitInterface::class.java)
        SignUpRetrofitInterface.getEmail().enqueue(object : Callback<EmailCheckResponse>{
            override fun onResponse(call: Call<EmailCheckResponse>, response: Response<EmailCheckResponse>) {
                (response.body() as EmailCheckResponse?)?.let {
                    GetEmailInterface.onGetEmailSuccess(
                        it
                    )
                }
            }

            override fun onFailure(call: Call<EmailCheckResponse>, t: Throwable) {
                GetEmailInterface.onGetEmailFailure(t.message ?: "통신 오류")
            }
        })
    }
}

