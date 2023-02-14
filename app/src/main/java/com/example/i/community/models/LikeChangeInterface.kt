package com.example.i.community.models

import com.example.i.config.BaseResponse

interface LikeChangeInterface {
    fun onPostChangeLikeSuccess(response: BaseResponse)
    fun onPostChangeLikeFailure(message: String)
}