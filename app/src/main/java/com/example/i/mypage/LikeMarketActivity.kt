package com.example.i.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.i.R
import com.example.i.databinding.ActivityLikeMarketBinding

class LikeMarketActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityLikeMarketBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityLikeMarketBinding.inflate(layoutInflater)

        viewBinding.backBtn.setOnClickListener {
            finish()
        }
        setContentView(viewBinding.root)
    }
}