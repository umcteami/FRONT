package com.example.i.community.talk.models

interface FeedsDeleteInterface {
    fun onPatchFeedsDeleteSuccess(response : FeedsDeleteResponse)
    fun onPatchFeedsDeleteFailure(message : String)
}