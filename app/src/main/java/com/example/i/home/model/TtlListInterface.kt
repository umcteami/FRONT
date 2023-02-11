package com.example.i.home.model

interface TtlListInterface {
    fun onGetTtlListSuccess(response: TtlListResponse)

    fun onGetTtlListFailure(message: String)
}