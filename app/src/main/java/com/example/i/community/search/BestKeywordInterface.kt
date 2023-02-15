package com.example.i.community.search

interface BestKeywordInterface {
    fun onGetBestKeywordSuccess(response : BestKeywordResponse)
    fun onGetBestKeywordFailure(message : String)
}