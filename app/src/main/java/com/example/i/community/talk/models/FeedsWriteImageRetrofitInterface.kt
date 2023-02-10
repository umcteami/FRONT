package com.example.i.community.talk.models

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.PartMap

interface FeedsWriteImageRetrofitInterface {
    @POST("feeds/write/img")
    fun postFeedsImageWrite(@Body params : PostFeedsWriteImageRequest) : Call<FeedsWriteImageResponse>
//
//    suspend fun apiPostFile(
//        @PartMap partMap: Map<String,@JvmSuppressWildcards RequestBody>,
//        @Part files : List<MultipartBody.Part>
//    ) : retrofit2.Response<ResponseWrapper<FileUploadResponse>>
}