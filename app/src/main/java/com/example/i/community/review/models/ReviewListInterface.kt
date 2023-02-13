package com.example.i.community.review.models

interface ReviewListInterface {
    fun onGetReviewListSuccess(response: ReviewListResponse)
    fun onGetReviewListFailure(message: String)
}