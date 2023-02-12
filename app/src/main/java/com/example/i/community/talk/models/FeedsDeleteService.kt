package com.example.i.community.talk.models

import com.example.i.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FeedsDeleteService (val FeedsDeleteInterface : FeedsDeleteInterface){
    fun tryPatchFeedsDelete(PatchFeedsDeleteRequest : PatchFeedsDeleteRequest){
        val feedsDeleteRetrofitInterface = ApplicationClass.sRetrofit.create(
            FeedsDeleteRetrofitInterface::class.java)
        feedsDeleteRetrofitInterface.patchFeedsDelete(PatchFeedsDeleteRequest).enqueue(object :
            Callback<FeedsDeleteResponse>{
            override fun onResponse(
                call: Call<FeedsDeleteResponse>,
                response: Response<FeedsDeleteResponse>
            ) {
                (response.body() as FeedsDeleteResponse)?.let{
                    FeedsDeleteInterface.onPatchFeedsDeleteSuccess(
                        it
                    )
                }
            }

            override fun onFailure(call: Call<FeedsDeleteResponse>, t: Throwable) {
                FeedsDeleteInterface.onPatchFeedsDeleteFailure(t.message?:"오류")
            }
            })
    }
}