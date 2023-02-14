package com.example.i.community.talk.models.talkroom

import com.google.gson.annotations.SerializedName

data class Img(
    @SerializedName("img") val img: ArrayList<ViewTalkroomList>
)