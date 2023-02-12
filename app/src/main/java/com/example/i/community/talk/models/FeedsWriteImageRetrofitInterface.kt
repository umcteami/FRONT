package com.example.i.community.talk.models

import okhttp3.MultipartBody
import okhttp3.Request
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface FeedsWriteImageRetrofitInterface {
    @Multipart
    @POST("/feeds/write")
    fun postFeedsImageWrite(
//        @PartMap request : Map<String, @JvmSuppressWildcards RequestBody>,
        @Part("request") request : RequestBody,
        @Part img : List<MultipartBody.Part?>
    ) : Call<FeedsWriteImageResponse>
}