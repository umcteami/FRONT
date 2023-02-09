package com.example.i.market.model

interface MarketWriteInterface {
    fun onPostMarketWriteSuccess(response : MarketWriteResponse)
    fun onPostMarketWriteFailure(message : String)
}