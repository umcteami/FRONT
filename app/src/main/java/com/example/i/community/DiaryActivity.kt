package com.example.i.community

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.i.databinding.ActivityDiaryBinding
import com.google.android.material.tabs.TabLayoutMediator

class DiaryActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityDiaryBinding
    private val tabTitleArray = arrayOf(
        "일기장 전체",
        "인기글"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityDiaryBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val viewPager = viewBinding.viewpager
        val tabLayout = viewBinding.tabLayout

        viewPager.adapter = ReviewViewPagerAdapter(supportFragmentManager, lifecycle)
        TabLayoutMediator(tabLayout, viewPager) {tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()

        val buttonSearch = viewBinding.btnSearch
        buttonSearch.setOnClickListener{
            val searchIntent = Intent(this, SearchActivity::class.java)
            startActivity(searchIntent)
        }

        val buttonWrite = viewBinding.btnWrite
        buttonWrite.setOnClickListener{
            val writeIntent = Intent(this, CommunityWriteActivity::class.java)
            startActivity(writeIntent)
        }
    }
}