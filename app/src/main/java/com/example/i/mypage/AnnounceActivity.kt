package com.example.i.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.i.databinding.ActivityAnnounceBinding
import com.example.i.databinding.FragmentRevokeBinding

class AnnounceActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityAnnounceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityAnnounceBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }
}