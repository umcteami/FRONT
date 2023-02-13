package com.example.i.community.search

interface ReviewSearchInterface {
    fun onGetReviewSearchSuccess(response : ReviewSearchResponse)
    fun onGetReviewSearchFailure(message : String)
}