package com.example.i.signup.models

import com.example.i.config.ApplicationClass
import com.example.i.signup.EmailFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostCodeService(val SignUpInterface: PostCodeInterface) {

    // 인증번호 보내기
    fun tryPostEmail(PostCodeRequest: PostCodeRequest){
        val EmailRetrofitInterface = ApplicationClass.sRetrofit.create(SignUpRetrofitInterface::class.java)
        EmailRetrofitInterface.postEmail(PostCodeRequest).enqueue(object : Callback<CodeResponse>{
            override fun onResponse(call: Call<CodeResponse>, response: Response<CodeResponse>) {
                SignUpInterface.onPostEmailSuccess(response.body() as CodeResponse)
            }

            override fun onFailure(call: Call<CodeResponse>, t: Throwable) {
                SignUpInterface.onPostEmailFailure(t.message ?: "통신 오류")
            }
        })
    }

    fun tryPostPhone(PostPhoneRequest: PostCodeRequest){
        val PhoneRetrofitInterface = ApplicationClass.sRetrofit.create(SignUpRetrofitInterface::class.java)
        PhoneRetrofitInterface.postPhone(PostPhoneRequest).enqueue(object : Callback<CodeResponse>{
            override fun onResponse(call: Call<CodeResponse>, response: Response<CodeResponse>) {
                this@PostCodeService.SignUpInterface.onPostPhoneSuccess(response.body() as CodeResponse)
            }

            override fun onFailure(call: Call<CodeResponse>, t: Throwable) {
                SignUpInterface.onPostPhoneFailure(t.message ?: "통신 오류")
            }
        })
    }
}

