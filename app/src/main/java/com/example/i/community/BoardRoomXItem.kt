package com.example.i.community

data class BoardRoomXItem(
    var hasImage : Boolean,
    var profile : Int?,
    var picture : Int?,
    val date: String,
    val writer: String,
    val title: String,
    var view: String,
    val heart: String,
    var comment: String
)
