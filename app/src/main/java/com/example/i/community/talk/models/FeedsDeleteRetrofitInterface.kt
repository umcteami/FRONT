package com.example.i.community.talk.models

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.PATCH

interface FeedsDeleteRetrofitInterface {
    @PATCH("/feeds/delete")
    fun patchFeedsDelete(@Body params : PatchFeedsDeleteRequest) : Call<FeedsDeleteResponse>
}