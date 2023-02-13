package com.example.i.community.review.models

import com.example.i.config.ApplicationClass
import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReviewWriteService(val ReviewWriteInterface : ReviewWriteInterface) {
    fun tryPostReviewWrite(PostReviewWriteRequest : PostReviewWriteRequest, images : List<MultipartBody.Part?>){
        val reviewWriteRetrofitInterface = ApplicationClass.sRetrofit.create(
            ReviewWriteRetrofitInterface::class.java)
        val requestBody = Gson().toJson(PostReviewWriteRequest)
            .toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())
        reviewWriteRetrofitInterface.postReviewWrite(requestBody, images).enqueue(object :
            Callback<ReviewWriteResponse>{
            override fun onResponse(
                call: Call<ReviewWriteResponse>,
                response: Response<ReviewWriteResponse>
            ) {
                (response.body() as ReviewWriteResponse?)?.let {
                    ReviewWriteInterface.onPostReviewWriteSuccess(
                        it
                    )
                }
            }
            override fun onFailure(call: Call<ReviewWriteResponse>, t: Throwable) {
                ReviewWriteInterface.onPostReviewWriteFailure(t.message ?: "통신 오류")
            }
            })
    }
}