package com.example.i.login

import com.example.i.login.models.SignUpResponse


interface LoginInterface {

    fun onPostSignUpSuccess(response: SignUpResponse)

    fun onPostSignUpFailure(message: String)
}