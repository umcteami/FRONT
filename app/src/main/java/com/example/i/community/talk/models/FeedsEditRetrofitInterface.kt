package com.example.i.community.talk.models

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.PATCH

interface FeedsEditRetrofitInterface {
    @PATCH("/feeds/edit")
    fun patchFeedsEdit(@Body params : PatchFeedsEditRequest) : Call<FeedsWriteResponse>
}