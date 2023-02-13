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
        PostRetrofitInterface.getPost(memIdx, page).enqueue(object : Callback<PostResponse>{
            override fun onResponse(call: Call<PostResponse>, response: Response<PostResponse>) {
                (response.body() as PostResponse?)?.let {
                    PostInterface.onGetPostSuccess(
                        it
                    )
                }
            }

            override fun onFailure(call: Call<PostResponse>, t: Throwable) {
                PostInterface.onGetPostFailure(t.message ?: "통신 오류")
            }
        })
    }

    // 일기장 작성 글 조회 API
    fun tryGetDiary(memIdx:Int, end: Int){
        val PostRetrofitInterface = ApplicationClass.sRetrofit.create(PostRetrofitInterface::class.java)
        PostRetrofitInterface.getDiary(memIdx, end).enqueue(object : Callback<PostResponse>{
            override fun onResponse(call: Call<PostResponse>, response: Response<PostResponse>) {
                (response.body() as PostResponse?)?.let {
                    PostInterface.onGetDiarySuccess(
                        it
                    )
                }
            }

            override fun onFailure(call: Call<PostResponse>, t: Throwable) {
                PostInterface.onGetDiaryFailure(t.message ?: "통신 오류")
            }
        })
    }
}
