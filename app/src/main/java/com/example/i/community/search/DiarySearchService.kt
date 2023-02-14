package com.example.i.community.search

import com.example.i.config.ApplicationClass
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response

class DiarySearchService (val DiarySearchInterface : DiarySearchInterface, val category : String?, val searchKeyword : String?, val page : Int?, val searchTarget : String){
    fun tryGetDiarySearch(){
        val DiarySearchRetrofitInterface = ApplicationClass.sRetrofit.create(DiarySearchRetrofitInterface::class.java)
        DiarySearchRetrofitInterface.getDiarySearch(category = category, searchKeyword = searchKeyword, page = 0, searchTarget=  searchTarget).enqueue(object:
        Callback<DiarySearchResponse>{
            override fun onResponse(
                call: Call<DiarySearchResponse>,
                response: Response<DiarySearchResponse>
            ) {
                (response.body() as DiarySearchResponse?)?.let{
                    DiarySearchInterface.onGetDiarySearchSuccess(
                        it
                    )
                }
            }

            override fun onFailure(call: Call<DiarySearchResponse>, t: Throwable) {
                DiarySearchInterface.onGetDiarySearchFailure(t.message?:"통신 오류")
            }
        }
        )
        }
}
