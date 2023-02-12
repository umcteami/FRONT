package com.example.i.community.talk.models

import com.example.i.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FeedsEditService (val FeedsEditInterface : FeedsEditInterface){
    fun tryPatchFeedsEdit(PatchFeedsEditRequest : PatchFeedsEditRequest){
        val feedsEditRetrofitInterface = ApplicationClass.sRetrofit.create(
            FeedsEditRetrofitInterface::class.java)
        feedsEditRetrofitInterface.patchFeedsEdit(PatchFeedsEditRequest).enqueue(object :
            Callback<FeedsWriteResponse> {
            override fun onResponse(
                call: Call<FeedsWriteResponse>,
                response: Response<FeedsWriteResponse>
            ) {
                (response.body() as FeedsWriteResponse)?.let{
                    FeedsEditInterface.onPatchFeedsEditSuccess(
                        it
                    )
                }
            }

            override fun onFailure(call: Call<FeedsWriteResponse>, t: Throwable) {
                FeedsEditInterface.onPatchFeedsEditFailure(t.message ?: "오류")
            }
        })
    }
}