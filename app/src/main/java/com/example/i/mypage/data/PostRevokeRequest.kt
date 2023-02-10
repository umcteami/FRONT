package com.example.i.mypage.data

import com.google.gson.annotations.SerializedName

data class PostRevokeRequest(
        @SerializedName("memIdx") val memIdx: Int
)