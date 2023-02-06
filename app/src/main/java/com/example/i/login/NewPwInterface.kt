package com.example.i.login

import com.example.i.login.models.NewPwResponse


interface NewPwInterface {

    fun onPatchNewPwSuccess(response: NewPwResponse)

    fun onPatchNewPwFailure(message: String)
}