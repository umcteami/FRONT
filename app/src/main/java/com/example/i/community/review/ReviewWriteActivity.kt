package com.example.i.community.review

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.i.databinding.ActivityReviewWriteBinding

class ReviewWriteActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityReviewWriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityReviewWriteBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }
}