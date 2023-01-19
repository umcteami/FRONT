package com.example.i.community

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.i.databinding.ActivityCommunityTalkroomBinding
import com.google.android.material.tabs.TabLayoutMediator

class CommunityTalkroomActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityCommunityTalkroomBinding
    private val tabTitleArray = arrayOf(
        "이야기방 전체",
        "인기글"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityCommunityTalkroomBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val toolbar = viewBinding.toolbar
        setSupportActionBar(toolbar)

        val viewPager = viewBinding.viewpager
        val tabLayout = viewBinding.tabLayout

        viewPager.adapter = CommunityViewPagerAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(tabLayout, viewPager){tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()

        val button_write = viewBinding.btnWrite
        button_write.setOnClickListener{
            supportFragmentManager
                .beginTransaction()
                .replace(viewBinding.constraintLayout.id, PostWrightFragment())
                .commitAllowingStateLoss()
        }
    }
}