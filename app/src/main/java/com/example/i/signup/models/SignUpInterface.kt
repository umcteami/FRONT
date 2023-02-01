package com.example.i.signup.models

import android.provider.ContactsContract.CommonDataKinds.Email
import com.example.i.login.models.LoginResponse

interface SignUpInterface {

    fun onPostEmailSuccess(response: EmailResponse)
    fun onPostEmailFailure(message: String)

//    fun onPostSignUpSuccess(response: SignUpResponse)
//    fun onPostSignUpFailure(message: String)
}