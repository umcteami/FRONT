package com.example.i.community.search

interface StorySearchInterface {
    fun onGetStorySearchSuccess(response : StorySearchResponse)
    fun onGetStorySearchFailure(message : String)
}