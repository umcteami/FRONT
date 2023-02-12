package com.example.i.community.talk.models.talkroom

interface ViewTalkroomInterface {

    fun onGetViewTalkroomSuccess(response: ViewTalkroomResponse)

    fun onGetViewTalkroomFailure(message: String)
}