package com.example.i.community

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.i.databinding.ActivityCommunityTalkroomBinding
import com.example.i.databinding.ActivityReviewBinding

class ReviewActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityReviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityReviewBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }
}