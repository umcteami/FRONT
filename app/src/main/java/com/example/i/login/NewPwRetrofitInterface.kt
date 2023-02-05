package com.example.i.login

import com.example.i.login.models.PostLoginRequest
import com.example.i.login.models.LoginResponse
import com.example.i.login.models.NewPwResponse
import com.example.i.login.models.PatchNewPwRequest
import retrofit2.Call
import retrofit2.http.*

interface NewPwRetrofitInterface {
    @PATCH("/member/{memIdx}/pw")
    fun patchNewPw(@Body params: PatchNewPwRequest): Call<NewPwResponse>
}
