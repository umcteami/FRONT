package com.example.i.home.model

interface PplListInterface {
    fun onGetPplListSuccess(response: PplListResponse)
    fun onGetPplListFailure(message: String)
}