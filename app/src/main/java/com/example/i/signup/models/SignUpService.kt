package com.example.i.signup.models

import android.provider.ContactsContract.CommonDataKinds.Email
import com.example.i.config.ApplicationClass
import com.example.i.login.models.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpService(val SignUpInterface: SignUpInterface) {

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

//    fun tryPostSignUp(PostSignUpRequest: PostSignUpRequest){
//        val SignUpRetrofitInterface = ApplicationClass.sRetrofit.create(SignUpRetrofitInterface::class.java)
//        SignUpRetrofitInterface.postSignUp(PostSignUpRequest).enqueue(object : Callback<SignUpResponse>{
//            override fun onResponse(call: Call<SignUpResponse>, response: Response<SignUpResponse>) {
//                (response.body() as SignUpResponse?)?.let {
//                    SignUpInterface.onPostSignUpSuccess(
//                        it
//                    )
//                }
//            }
//
//            override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
//                SignUpInterface.onPostSignUpFailure(t.message ?: "통신 오류")
//            }
//        })
//    }
}

