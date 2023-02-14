package com.example.i.login.models

import com.example.i.config.ApplicationClass
import com.example.i.signup.EmailFragment
import com.example.i.signup.models.CodeResponse
import com.example.i.signup.models.CodeRetrofitInterface
import com.example.i.signup.models.PostCodeInterface
import com.example.i.signup.models.PostCodeRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostPhoneService(val PostPhoneInterface: PostPhoneInterface) {

    // 인증번호 보내기
    fun tryPostPhone(PostPhoneRequest: PostCodeRequest){
        val FindRetrofitInterface = ApplicationClass.sRetrofit.create(FindRetrofitInterface::class.java)
        FindRetrofitInterface.postPhone(PostPhoneRequest, find = 1).enqueue(object : Callback<CodeResponse>{
            override fun onResponse(call: Call<CodeResponse>, response: Response<CodeResponse>) {
                PostPhoneInterface.onPostPhoneSuccess(response.body() as CodeResponse)
            }

            override fun onFailure(call: Call<CodeResponse>, t: Throwable) {
                PostPhoneInterface.onPostPhoneFailure(t.message ?: "통신 오류")
            }
        })
    }
}

