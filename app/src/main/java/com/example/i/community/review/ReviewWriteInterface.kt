package com.example.i.community.review

interface ReviewWriteInterface {
    fun onPostReviewWriteSuccess(response : ReviewWriteResponse)
    fun onPostReviewWriteFailure(message : String)
}