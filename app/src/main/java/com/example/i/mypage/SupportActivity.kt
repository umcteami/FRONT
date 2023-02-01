package com.example.i.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.i.databinding.ActivityAnnounceBinding
import com.example.i.databinding.ActivitySupportBinding

class SupportActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivitySupportBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySupportBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }
}