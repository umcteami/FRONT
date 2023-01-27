package com.example.i.community

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.i.databinding.ActivityCommunityWrite2Binding

class CommunityWriteActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityCommunityWrite2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityCommunityWrite2Binding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }
}