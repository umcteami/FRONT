package com.example.i.community.models

interface CommentInterface {
    fun onGetCommentSuccess(response: CommentResponse)
    fun onGetCommentFailure(message: String)
}