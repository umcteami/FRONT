package com.example.i.community.talk.models.talkroom

interface PplTalkroomInterface {
    fun onGetPplTalkroomSuccess(response: PplTalkroomResponse)
    fun onGetPplTalkroomFailure(message: String)
}