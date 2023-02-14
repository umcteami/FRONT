package com.example.i.community.review

import com.example.i.home.HasImage

data class ReviewItem(
    var hasImage: HasImage? = null,
    var seller: String? = null,
    var goods : String? = null,
    var profile : String? = null,
    var writer: String? = null,
    var date: String? = null,
    var view : String? = null,
    var heart : String? = null,
    var comment: String? = null,
    var img: String? = null
)
