package com.example.i.community.talk.models.talkroom

import com.google.gson.annotations.SerializedName

data class Feed(
    @SerializedName("feed") val feed: ArrayList<ViewTalkroomList>
)