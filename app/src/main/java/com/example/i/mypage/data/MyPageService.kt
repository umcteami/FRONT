package com.example.i.mypage.data

import com.example.i.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyPageService(val MyPageInterface: MyPageInterface) {
    // 마이페이지 시작창 조회 API
    fun tryGetMyPage(memIdx : Int){
        val MyPageRetrofitInterface = ApplicationClass.sRetrofit.create(MyPageRetrofitInterface::class.java)
        MyPageRetrofitInterface.getMyPage(memIdx).enqueue(object : Callback<MyPageResponse>{
            override fun onResponse(call: Call<MyPageResponse>, response: Response<MyPageResponse>) {
                (response.body() as MyPageResponse?)?.let {
                    MyPageInterface.onGetMyPageSuccess(
                        it
                    )
                }
            }

            override fun onFailure(call: Call<MyPageResponse>, t: Throwable) {
                MyPageInterface.onGetMyPageFailure(t.message ?: "통신 오류")
            }
        })
    }
}
