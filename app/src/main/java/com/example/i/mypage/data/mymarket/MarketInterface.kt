package com.example.i.mypage.data.mymarket


interface MarketInterface {
    // 나눔장터 작성 글 조회 API
    fun onGetMarketSuccess(response: MarketResponse)
    fun onGetMarketFailure(message: String)
}