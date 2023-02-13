package com.example.i.community.search

import com.example.i.home.HasImage

data class ReviewSearchItem(
    var hasImage : HasImage? = null,
    var title : String? = null,
    var writer : String? = null,
    var date : String? = null,
    var view : String? = null,
    var heart : String? = null,
    var comment : String? = null,
    var picture : String? = null
)