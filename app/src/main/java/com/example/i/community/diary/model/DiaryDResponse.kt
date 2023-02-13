package com.example.i.community.diary.model

import com.google.gson.annotations.SerializedName

data class DiaryDResponse(
    @SerializedName("result") val result: ArrayList<DiaryDList>
)
