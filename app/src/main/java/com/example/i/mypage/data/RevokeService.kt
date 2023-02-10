package com.example.i.mypage.data

import com.example.i.config.ApplicationClass
import com.example.i.config.BaseResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RevokeService(val RevokeInterface: RevokeInterface) {
    // 탈퇴하기 API
    fun tryPostRevoke(memIdx: Int){
        val RevokeRetrofitInterface = ApplicationClass.sRetrofit.create(RevokeRetrofitInterface::class.java)
        RevokeRetrofitInterface.postRevoke(memIdx).enqueue(object : Callback<BaseResponse>{
            override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                (response.body() as BaseResponse?)?.let {
                    RevokeInterface.onPostRevokeSuccess(
                        it
                    )
                }
            }

            override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                RevokeInterface.onPostRevokeFailure(t.message ?: "통신 오류")
            }
        })
    }
}
