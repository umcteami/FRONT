package com.example.i.community.search

interface DiarySearchInterface {
    fun onGetDiarySearchSuccess(response : DiarySearchResponse)
    fun onGetDiarySearchFailure(message : String)
}