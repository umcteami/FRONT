package com.example.i.signup.models

import com.example.i.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostSignUpService(val PostSignUpInterface: PostSignUpInterface) {
    // 회원가입 API
//    fun tryPostSignUp(PostSignUpRequest: PostSignUpRequest){
//        val SignUpRetrofitInterface = ApplicationClass.sRetrofit.create(SignUpRetrofitInterface::class.java)
//        SignUpRetrofitInterface.postJoin(PostSignUpRequest).enqueue(object : Callback<SignUpResponse>{
//            override fun onResponse(call: Call<SignUpResponse>, response: Response<SignUpResponse>) {
//                (response.body() as SignUpResponse?)?.let {
//                    PostSignUpInterface.onPostSignUpSuccess(
//                        it
//                    )
//                }
//            }
//
//            override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
//                PostSignUpInterface.onPostSignUpFailure(t.message ?: "통신 오류")
//            }
//        })
//    }
}

