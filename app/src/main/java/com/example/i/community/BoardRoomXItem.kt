package com.example.i.community

import com.example.i.home.HasImage

data class BoardRoomXItem(
    var hasImage : HasImage? = null,
    var title: String? = null,
    var picture : String? = null,
    var writer: String? = null,
    var date: String? = null,
    var view : String? = null,
    var heart : String? = null,
    var comment: String? = null
)
