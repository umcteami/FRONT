package com.example.i

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.i.databinding.ActivityCommunityTalkroomBinding
import com.google.android.material.tabs.TabLayoutMediator

class Community_TalkroomActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCommunityTalkroomBinding
    private val tabTitleArray = arrayOf(
        "이야기방 전체",
        "인기글"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommunityTalkroomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)

        val viewPager = binding.viewpager
        val tabLayout = binding.tabLayout

        viewPager.adapter = CommunityViewPagerAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(tabLayout, viewPager){tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()
    }
}