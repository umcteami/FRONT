package com.example.i.mypage.data

import com.example.i.config.BaseResponse
import retrofit2.Call
import retrofit2.http.*

interface RevokeRetrofitInterface {
    // 탈퇴하기 API
    @FormUrlEncoded
    @POST("/member/withdraw")
    fun postRevoke(@Field ("memIdx") memIdx: Int): Call<BaseResponse>
}
