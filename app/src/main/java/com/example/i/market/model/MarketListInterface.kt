package com.example.i.market.model

interface MarketListInterface {
    fun onGetMarketListSuccess(response: MarketListResponse)
    fun onGetMarketListFailure(message: String)
}