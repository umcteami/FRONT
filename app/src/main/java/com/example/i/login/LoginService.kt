package com.example.i.login

import com.example.i.config.ApplicationClass
import com.example.i.login.models.PostLoginRequest
import com.example.i.login.models.SignUpResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginService(val homeFragmentInterface: LoginInterface) {

    fun tryPostSignUp(postSignUpRequest: PostLoginRequest){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(LoginRetrofitInterface::class.java)
        homeRetrofitInterface.postSignUp(postSignUpRequest).enqueue(object : Callback<SignUpResponse>{
            override fun onResponse(call: Call<SignUpResponse>, response: Response<SignUpResponse>) {
                (response.body() as SignUpResponse?)?.let {
                    homeFragmentInterface.onPostSignUpSuccess(
                        it
                    )
                }
            }

            override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                homeFragmentInterface.onPostSignUpFailure(t.message ?: "통신 오류")
            }
        })
    }

}
