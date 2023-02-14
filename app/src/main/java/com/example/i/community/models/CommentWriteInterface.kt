package com.example.i.community.models

interface CommentWriteInterface {
    fun onPostCommentWriteSuccess(response: CommentWriteResponse)
    fun onPostCommentWriteFailure(message: String)
}