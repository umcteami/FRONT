package com.example.i.community.talk.models

interface FeedsWriteImageInterface {
    fun onPostFeedsImageWriteSuccess(response : FeedsWriteImageResponse)
    fun onPostFeedsImageWriteFailure(message : String)
}