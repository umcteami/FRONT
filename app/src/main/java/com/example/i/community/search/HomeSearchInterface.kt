package com.example.i.community.search

interface HomeSearchInterface {
    fun onGetHomeSearchSuccess(response : HomeSearchResponse)
    fun onGetHomeSearchFailure(message : String)
}