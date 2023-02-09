package com.example.i.community.talk.models

interface FeedsWriteInterface {
    fun onPostFeedsWriteSuccess(response : FeedsWriteResponse)
    fun onPostFeedsWriteFailure(message : String)
}