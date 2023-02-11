package com.example.i.mypage.data.like

import com.example.i.config.ApplicationClass
import com.example.i.mypage.data.want.WantInterface
import com.example.i.mypage.data.want.WantResponse
import com.example.i.mypage.data.want.WantRetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LikeService(val LikeInterface: LikeInterface) {

    // 좋아요한 게시글 API
    fun tryGetLike(memIdx:Int, page: Int){
        val LikeRetrofitInterface = ApplicationClass.sRetrofit.create(LikeRetrofitInterface::class.java)
        LikeRetrofitInterface.getWant(memIdx, page).enqueue(object : Callback<LikeResponse>{
            override fun onResponse(call: Call<LikeResponse>, response: Response<LikeResponse>) {
                (response.body() as LikeResponse?)?.let {
                    LikeInterface.onGetLikeSuccess(
                        it
                    )
                }
            }

            override fun onFailure(call: Call<LikeResponse>, t: Throwable) {
                LikeInterface.onGetLikeFailure(t.message ?: "통신 오류")
            }
        })
    }
}
