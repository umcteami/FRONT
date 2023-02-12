package com.example.i.community.talk.models


import com.example.i.config.ApplicationClass
import com.google.gson.Gson
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class FeedsWriteImageService (val FeedsWriteImageInterface : FeedsWriteImageInterface) {
//    fun sendPostFeedsWriteRequest(request : RequestBody, images : MultipartBody.Part) {
//        val feedsWriteImageRetrofitInterface = ApplicationClass.sRetrofit.create(
//            FeedsWriteImageRetrofitInterface::class.java)
//        feedsWriteImageRetrofitInterface.postFeedsImageWrite(request, images).enqueue(
//            object : Callback<FeedsWriteImageResponse> {
//                override fun onResponse(
//                    call: Call<FeedsWriteImageResponse>,
//                    response: Response<FeedsWriteImageResponse>) {
//                    (response.body() as FeedsWriteImageResponse)?.let{
//                    FeedsWriteImageInterface.onPostFeedsImageWriteSuccess(
//                        it
//                    )
//                    }
//                }
//                override fun onFailure(call: Call<FeedsWriteImageResponse>, t: Throwable) {
//                FeedsWriteImageInterface.onPostFeedsImageWriteFailure(t.message?: "오류")
//                }
//            })
//    }
}