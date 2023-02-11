package com.example.i.mypage.data.post

import com.example.i.config.ApplicationClass
import com.example.i.mypage.data.like.LikeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostService(val PostInterface: PostInterface) {
    // 작성 글 조회 API
    fun tryGetPost(memIdx:Int, page: Int){
        val PostRetrofitInterface = ApplicationClass.sRetrofit.create(PostRetrofitInterface::class.java)
        PostRetrofitInterface.getPost(memIdx, page).enqueue(object : Callback<LikeResponse>{
            override fun onResponse(call: Call<LikeResponse>, response: Response<LikeResponse>) {
                (response.body() as LikeResponse?)?.let {
                    PostInterface.onGetPostSuccess(
                        it
                    )
                }
            }

            override fun onFailure(call: Call<LikeResponse>, t: Throwable) {
                PostInterface.onGetPostFailure(t.message ?: "통신 오류")
            }
        })
    }
}
