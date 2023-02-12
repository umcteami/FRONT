package com.example.i.signup.models

import com.example.i.config.ApplicationClass
import com.example.i.config.BaseResponse
import com.example.i.signup.body
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostSignUpService(val PostSignUpInterface: PostSignUpInterface) {
    // 회원가입 API
    fun tryPostSignUp(PostSignUpRequest: PostSignUpRequest){
        val SignUpRetrofitInterface = ApplicationClass.sRetrofit.create(SignUpRetrofitInterface::class.java)
        SignUpRetrofitInterface.postJoin(PostSignUpRequest, body).enqueue(object : Callback<BaseResponse>{
            override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                (response.body() as BaseResponse?)?.let {
                    PostSignUpInterface.onPostSignUpSuccess(
                        it
                    )
                }
            }

            override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                PostSignUpInterface.onPostSignUpFailure(t.message ?: "통신 오류")
            }
        })
    }
}

