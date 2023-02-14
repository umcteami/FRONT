package com.example.i.community.models

interface HomeSearchInterface {
    fun onGetHomeSearchSuccess(response : HomeSearchResponse)
    fun onGetHomeSearchFailure(message : String)
}