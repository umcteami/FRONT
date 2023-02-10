package com.example.i.login

import com.example.i.config.BaseResponse
import com.example.i.login.models.PostNewPwRequest
import retrofit2.Call
import retrofit2.http.*

interface NewPwRetrofitInterface {
    @POST("/member/find/pw")
    fun postNewPw(@Body params: PostNewPwRequest): Call<BaseResponse>
}
