package com.example.i.community.talk.models.diaryT

import com.example.i.config.BaseResponse
import com.example.i.home.model.TtlList
import com.google.gson.annotations.SerializedName

data class DiaryResponse(
    @SerializedName("result") val result: ArrayList<DiaryList>
): BaseResponse()
