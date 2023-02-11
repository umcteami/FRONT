package com.example.i.community.review.models

interface ReviewDeleteInterface {
    fun onPatchReviewDeleteSuccess(response : ReviewDeleteResponse)
    fun onPatchReviewDeleteFailure(message : String)
}