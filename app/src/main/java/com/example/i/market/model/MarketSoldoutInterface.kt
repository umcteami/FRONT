package com.example.i.market.model

interface MarketSoldoutInterface {
    fun onPutMarketSoldoutSuccess(response : MarketSoldoutResponse)
    fun onPutMarketSoldoutFailure(message : String)
}