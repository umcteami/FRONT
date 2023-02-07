package com.example.i.login
import com.example.i.config.BaseResponse

interface NewPwInterface {
    fun onPatchNewPwSuccess(response: BaseResponse)
    fun onPatchNewPwFailure(message: String)
}