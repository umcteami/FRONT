package com.example.i.login

import com.example.i.login.models.PostLoginRequest
import com.example.i.login.models.LoginResponse
import retrofit2.Call
import retrofit2.http.*

interface LoginRetrofitInterface {
    @POST("/member/login")
    fun postLogin(@Body params: PostLoginRequest): Call<LoginResponse>
}
