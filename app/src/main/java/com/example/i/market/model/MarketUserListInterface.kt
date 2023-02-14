package com.example.i.market.model

interface MarketUserListInterface {

    fun onGetMarketUserListSuccess(response: MarketUserListResponse)

    fun onGetChatListFailure(message: String)

}