package com.example.i.login.models

import com.example.i.login.phone
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.*

interface FindRetrofitInterface {
    // 이메일 찾기 API
    @GET("/member/find/email")
    fun getFind(@Query("phone") phone: String): Call<FindResponse>
}
