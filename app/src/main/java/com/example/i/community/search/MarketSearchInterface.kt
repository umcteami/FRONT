package com.example.i.community.search

interface MarketSearchInterface {
    fun onGetMarketSearchSuccess(response : MarketSearchResponse)
    fun onGetMarketSearchFailure(message : String)
}