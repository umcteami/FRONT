package com.example.i.mypage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.i.databinding.ActivityLikePostBinding
import com.google.android.material.tabs.TabLayoutMediator

class LikePostActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityLikePostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityLikePostBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.backBtn.setOnClickListener {
            finish()
        }

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewBinding.viewPager.adapter = adapter

        val tabTitleArray = arrayOf(
            "이야기방",
            "다이어리",
            "정보공유"
        )

        TabLayoutMediator(viewBinding.tabs, viewBinding.viewPager) { tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()
    }
}