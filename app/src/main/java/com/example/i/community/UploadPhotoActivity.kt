package com.example.i.community

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.i.R
import com.example.i.databinding.ActivityReviewSearchBinding
import com.example.i.databinding.ActivityUploadPhotoBinding

class UploadPhotoActivity : AppCompatActivity() {
    private lateinit var viewBinding : ActivityUploadPhotoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityUploadPhotoBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }
}