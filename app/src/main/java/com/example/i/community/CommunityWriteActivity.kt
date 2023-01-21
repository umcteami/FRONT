package com.example.i.community

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.i.databinding.ActivityCommunityWriteBinding

class CommunityWriteActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityCommunityWriteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityCommunityWriteBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }
}