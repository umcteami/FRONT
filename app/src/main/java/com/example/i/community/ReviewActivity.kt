package com.example.i.community

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.i.databinding.ActivityReviewBinding
import com.google.android.material.tabs.TabLayoutMediator

class ReviewActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityReviewBinding
    private val tabTitleArray = arrayOf(
        "장터후기",
        "인기글"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityReviewBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val viewPager = viewBinding.viewpager
        val tabLayout = viewBinding.tabLayout

        viewPager.adapter = CommunityViewPagerAdapter(supportFragmentManager, lifecycle)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()

        val buttonSearch = viewBinding.btnSearch
        buttonSearch.setOnClickListener {
            val searchIntent = Intent(this, ReviewSearchActivity::class.java)
            startActivity(searchIntent)
        }
        val buttonWrite = viewBinding.btnWrite
        buttonWrite.setOnClickListener {
            val writeIntent = Intent(this, ReviewWriteActivity::class.java)
            startActivity(writeIntent)
        }
    }
}