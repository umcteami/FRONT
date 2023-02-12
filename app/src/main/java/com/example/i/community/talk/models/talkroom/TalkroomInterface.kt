package com.example.i.community.talk.models.talkroom

interface TalkroomInterface {
    fun onGetTalkroomSuccess(response: TalkroomResponse)

    fun onGetTalkroomFailure(message: String)
}