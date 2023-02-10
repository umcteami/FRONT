package com.example.i.mypage.data

import retrofit2.Call
import retrofit2.http.*

interface MyPageRetrofitInterface {
    // 마이페이지 시작창 조회 API
    @GET("/mypage/33")
    fun getMyPage(): Call<MyPageResponse>
}
