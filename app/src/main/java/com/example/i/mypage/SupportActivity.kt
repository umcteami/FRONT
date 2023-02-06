package com.example.i.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.i.databinding.ActivitySupportBinding
import com.google.android.material.tabs.TabLayoutMediator

class SupportActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivitySupportBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySupportBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val SupportAdapter = SupportVPAdapter(this)
        viewBinding.viewPager.adapter = SupportAdapter

        val tabTitleArray = arrayOf(
            "도움말",
            "문의하기"
        )

        TabLayoutMediator(viewBinding.tabs, viewBinding.viewPager){ tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()

        viewBinding.backBtn.setOnClickListener {
            finish()
        }


    }
}