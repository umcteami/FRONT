package com.example.i.community.talk.models.talk

interface TalkInterface {
    fun onGetTalkSuccess(response:TalkResponse)
    fun onGetTalkFailure(message: String)

}