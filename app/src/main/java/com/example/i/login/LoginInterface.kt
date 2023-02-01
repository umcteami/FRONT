package com.example.i.login

import com.example.i.login.models.LoginResponse


interface LoginInterface {

    fun onPostLoginSuccess(response: LoginResponse)

    fun onPostLoginFailure(message: String)
}