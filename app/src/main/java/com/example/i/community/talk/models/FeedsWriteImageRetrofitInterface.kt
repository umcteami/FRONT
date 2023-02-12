package com.example.i.community.talk.models

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.PartMap

interface FeedsWriteImageRetrofitInterface {
    @Multipart
    @POST("feeds/write")
    fun postFeedsImageWrite(
        @Part("request") result : RequestBody,
        @Part img : MultipartBody.Part?,
    ) : Call<FeedsWriteImageResponse>
}