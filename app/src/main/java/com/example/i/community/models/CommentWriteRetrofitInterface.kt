package com.example.i.community.models

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface CommentWriteRetrofitInterface {
    @POST("/feeds/comment/write")
    fun postCommentWrite(
        @Body parmas: RequestCommentWrite
    ): Call<CommentWriteResponse>
}