package com.example.i.community.models

import com.example.i.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentService(val CommentInterface: CommentInterface) {
    fun tryGetComment(boardType: Int, feedIdx: Int) {
        val CommentRetrofitInterface = ApplicationClass.sRetrofit.create(CommentRetrofitInterface::class.java)
        CommentRetrofitInterface.getComment(boardType, feedIdx).enqueue(object:
            Callback<CommentResponse> {
            override fun onResponse(
                call: Call<CommentResponse>,
                response: Response<CommentResponse>
            ) {
                (response.body() as CommentResponse?)?.let {
                    CommentInterface.onGetCommentSuccess(it)
                }
            }

            override fun onFailure(call: Call<CommentResponse>, t: Throwable) {
                CommentInterface.onGetCommentFailure(t.message ?: "통신 오류")
            }

        })
    }
}