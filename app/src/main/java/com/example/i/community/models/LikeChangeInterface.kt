package com.example.i.community.models

interface LikeChangeInterface {
    fun onPostChangeLikeSuccess(response: LikeChangeResponse)
    fun onPostChangeLikeFailure(message: String)
}