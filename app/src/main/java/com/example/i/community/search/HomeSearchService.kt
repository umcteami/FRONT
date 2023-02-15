package com.example.i.community.search

import com.example.i.config.ApplicationClass
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class HomeSearchService (val HomeSearchInterface : HomeSearchInterface, val searchKeyword : String?, val page : Int?, val searchTarget : String){
    fun tryGetHomeSearch(){
        val HomeSearchRetrofitInterface = ApplicationClass.sRetrofit.create(HomeSearchRetrofitInterface::class.java)
        HomeSearchRetrofitInterface.getHomeSearch(searchKeyword, page = 0, searchTarget).enqueue(object:
            Callback<HomeSearchResponse>
        {
            override fun onResponse(
                call: Call<HomeSearchResponse>,
                response: Response<HomeSearchResponse>
            ) {
                (response.body() as HomeSearchResponse?)?.let{
                    HomeSearchInterface.onGetHomeSearchSuccess(
                        it
                    )
                }
            }

            override fun onFailure(call: Call<HomeSearchResponse>, t: Throwable) {

                HomeSearchInterface.onGetHomeSearchFailure(t.message ?: "통신 오류")
            }
        }
        )

    }
}