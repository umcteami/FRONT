package com.example.i.login

import com.example.i.login.models.NewPwResponse
import com.example.i.login.models.PatchNewPwRequest
import retrofit2.Call
import retrofit2.http.*

interface NewPwRetrofitInterface {
    @PATCH("/member/30/pw")
    fun patchNewPw(@Body params: PatchNewPwRequest): Call<NewPwResponse>
}
