package com.example.i.signup.models

import com.example.i.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpService(val SignUpInterface: PostEmailInterface) {

    // 인증번호 보내기
    fun tryPostEmail(PostEmailRequest: PostEmailRequest){
        val EmailRetrofitInterface = ApplicationClass.sRetrofit.create(SignUpRetrofitInterface::class.java)
        EmailRetrofitInterface.postEmail(PostEmailRequest).enqueue(object : Callback<EmailResponse>{
            override fun onResponse(call: Call<EmailResponse>, response: Response<EmailResponse>) {
                this@SignUpService.SignUpInterface.onPostEmailSuccess(response.body() as EmailResponse)
            }

            override fun onFailure(call: Call<EmailResponse>, t: Throwable) {
                SignUpInterface.onPostEmailFailure(t.message ?: "통신 오류")
            }
        })
    }
}

