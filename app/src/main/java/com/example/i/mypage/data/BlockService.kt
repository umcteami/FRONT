package com.example.i.mypage.data

import com.example.i.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BlockService(val BlockInterface: BlockInterface) {
    // 차단한 사용자 API
    fun tryGetBlock(){
        val BlockRetrofitInterface = ApplicationClass.sRetrofit.create(BlockRetrofitInterface::class.java)
        BlockRetrofitInterface.getBlock().enqueue(object : Callback<BlockResponse>{
            override fun onResponse(call: Call<BlockResponse>, response: Response<BlockResponse>) {
                (response.body() as BlockResponse?)?.let {
                    BlockInterface.onGetBlockSuccess(
                        it
                    )
                }
            }

            override fun onFailure(call: Call<BlockResponse>, t: Throwable) {
                BlockInterface.onGetBlockFailure(t.message ?: "통신 오류")
            }
        })
    }
}
