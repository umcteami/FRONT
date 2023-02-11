package com.example.i.home.model

import com.example.i.config.BaseResponse
import com.example.i.mypage.data.PostAskRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Query

interface TtlListRetrofitInterface {

        @GET("/feeds")
        fun getTtlList(
                @Query("page") page: Int
        ): Call<TtlListResponse>

}