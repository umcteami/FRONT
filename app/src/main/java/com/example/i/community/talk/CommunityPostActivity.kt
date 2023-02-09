package com.example.i.community.talk

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.i.databinding.ActivityCommunityPostBinding

class CommunityPostActivity : AppCompatActivity() {
    private lateinit var viewBinding : ActivityCommunityPostBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityCommunityPostBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }
}