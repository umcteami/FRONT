package com.example.i.mypage.data

import retrofit2.Call
import retrofit2.http.*

interface BlockRetrofitInterface {
    // 차단한 사용자 API
    @GET("/member/{memIdx}")
    fun getBlock(
        @Path("memIdx") memIdx: Int
    ): Call<BlockResponse>
}
