package com.example.i.community.talk.models.talkroom

import com.example.i.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class ViewTalkroomResponse(

    @SerializedName("result") val result: ArrayList<ViewTalkroomList>,
    //@SerializedName("img") val img:ArrayList<String>

):BaseResponse()
