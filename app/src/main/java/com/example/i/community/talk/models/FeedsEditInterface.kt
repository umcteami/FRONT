package com.example.i.community.talk.models

interface FeedsEditInterface {
    fun onPatchFeedsEditSuccess(response : FeedsWriteResponse)
    fun onPatchFeedsEditFailure(message : String)
}