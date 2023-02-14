package com.example.i.community.models

import com.example.i.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentWriteService(val CommentWriteInterface: CommentWriteInterface) {
    fun tryPostCommentWrite(body: RequestCommentWrite) {
        val CommentWriteRetrofitInterface = ApplicationClass.sRetrofit.create(CommentWriteRetrofitInterface::class.java)
        CommentWriteRetrofitInterface.postCommentWrite(body).enqueue(object: Callback<CommentWriteResponse> {
            override fun onResponse(
                call: Call<CommentWriteResponse>,
                response: Response<CommentWriteResponse>
            ) {
                (response.body() as CommentWriteResponse?)?.let {
                    CommentWriteInterface.onPostCommentWriteSuccess(it)
                }
            }

            override fun onFailure(call: Call<CommentWriteResponse>, t: Throwable) {
                CommentWriteInterface.onPostCommentWriteFailure(t.message ?: "통신 오류")
            }

        })
    }
}