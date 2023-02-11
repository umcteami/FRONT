package com.example.i.community.review.models

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.PATCH

interface ReviewDeleteRetrofitInterface {
    @PATCH("/review/delete")
    fun patchReviewDelete(@Body params : PatchReviewDeleteRequest) : Call<ReviewDeleteResponse>
}