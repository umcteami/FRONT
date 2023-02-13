package com.example.i.home.model

interface HotTtlListInterface {
    fun onGetHotTtlListSuccess(response: HotTtlListResponse)
    fun onGetHotTtlListFailure(message: String)
}