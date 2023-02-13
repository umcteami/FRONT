package com.example.i.community.search

import com.example.i.config.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StorySearchService (val StorySearchInterface : StorySearchInterface){
    fun tryGetStorySearch(){
        val StorySearchRetrofitInterface = ApplicationClass.sRetrofit.create(StorySearchRetrofitInterface::class.java)
        StorySearchRetrofitInterface.getStorySearch(category = "justchat" , searchKeyword = "test", page = 0, searchTarget = "title").enqueue(object:
            Callback<StorySearchResponse>{
            override fun onResponse(
                call: Call<StorySearchResponse>,
                response: Response<StorySearchResponse>
            ) {
                (response.body() as StorySearchResponse?)?.let{
                    StorySearchInterface.onGetStorySearchSuccess(
                        it
                    )
                }
            }
            override fun onFailure(call: Call<StorySearchResponse>, t: Throwable) {
                StorySearchInterface.onGetStorySearchFailure(t.message?:"통신 오류")
            }
            })
    }
}