package com.example.i.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.i.databinding.ActivityRevokeBinding

class RevokeActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityRevokeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityRevokeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.backBtn.setOnClickListener {
            finish()
        }

    }
}