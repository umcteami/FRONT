package com.example.i.community

import com.example.i.home.HasImage

data class BoardItem(
    var hasImage : HasImage,
    var type: String,
    var title: String,
    var postImg : String?,
    var profile: String?,
    var writer: String,
    var date: String,
    var view : String,
    var heart : String,
    var comment: String
    )