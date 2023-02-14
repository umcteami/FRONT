package com.example.i.community.review

import com.example.i.home.HasImage

data class BestReviewItem(
    var hasImage : HasImage? = null,
    var title: String? = null,
    var img : String? = null,
    var writer: String? = null,
    var profile:String? = null,
    var date: String? = null,
    var view : String? = null,
    var heart : String? = null,
    var comment: String? = null
)
