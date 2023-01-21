package com.example.i.community

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.i.databinding.ActivityReviewSearchBinding
import com.google.android.material.tabs.TabLayoutMediator

class ReviewSearchActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityReviewSearchBinding
    private val tabTitleArray = arrayOf(
        "제목+내용",
        "제목",
        "작성자"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityReviewSearchBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val viewPager = viewBinding.viewPager
        val tabLayout = viewBinding.tabLayout
        viewPager.adapter = SearchviewPagerAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()
    }
}