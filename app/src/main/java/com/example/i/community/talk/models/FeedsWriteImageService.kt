package com.example.i.community.talk.models

import com.example.i.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FeedsWriteImageService (val FeedsWriteImageInterface : FeedsWriteImageInterface) {
    fun tryPostFeedsImageWrite(PostFeedsWriteImageRequest : PostFeedsWriteImageRequest){
        val feedsWriteImageRetrofitInterface = ApplicationClass.sRetrofit.create(
            FeedsWriteImageRetrofitInterface::class.java)
        feedsWriteImageRetrofitInterface.postFeedsImageWrite(PostFeedsWriteImageRequest).enqueue(
            object:Callback<FeedsWriteImageResponse>{
                override fun onResponse(
                    call: Call<FeedsWriteImageResponse>,
                    response: Response<FeedsWriteImageResponse>
                ) {
                    (response.body() as FeedsWriteImageResponse)?.let{
                        FeedsWriteImageInterface.onPostFeedsImageWriteSuccess(
                            it
                        )
                    }
                }

                override fun onFailure(call: Call<FeedsWriteImageResponse>, t: Throwable) {
                    FeedsWriteImageInterface.onPostFeedsImageWriteFailure(t.message?: "오류")
                }

        }
        )
    }

}