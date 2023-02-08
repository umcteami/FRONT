package com.example.i.community.review.models

interface ReviewWriteInterface {
    fun onPostReviewWriteSuccess(response : ReviewWriteResponse)
    fun onPostReviewWriteFailure(message : String)
}