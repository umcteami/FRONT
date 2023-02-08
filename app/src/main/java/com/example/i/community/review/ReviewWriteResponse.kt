package com.example.i.community.review

data class ReviewWriteResponse(
    var isSuccess : Boolean,
    var code : Int,
    var message : String,
    var resultIdx : Int
)
