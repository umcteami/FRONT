package com.example.i.community.search

import com.google.gson.annotations.SerializedName

data class ReviewSearchList(
    @SerializedName("reviewIdx")val reviewIdx : Int,
    @SerializedName("buyerIdx")val buyerIdx : Int,
    @SerializedName("sellerIdx")val sellerIdx : Int,
    @SerializedName("buyerNick")val buyerNick : String,
    @SerializedName("sellerNick")val sellerNick : String,
    @SerializedName("goods") val goods : String,
    @SerializedName("hit")val hit : Int,
    @SerializedName("createAt")val createAt : String
)
