package com.example.i.community

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.i.databinding.ActivitySearchResultBinding
import com.google.android.material.tabs.TabLayoutMediator

class SearchResultActivity : AppCompatActivity() {
    private lateinit var viewBinding : ActivitySearchResultBinding
//    private var searchKeyword : String = ""
    private var searchTarget : String = ""
    private var page : Int = 1
    private val tabTitleArray = arrayOf(
        "제목+내용",
        "제목",
        "작성자"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySearchResultBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val viewPager = viewBinding.viewPager
        val tabLayout = viewBinding.tabLayout
        searchTarget = tabTitleArray.toString()

        viewPager.adapter = ReviewSearchviewPagerAdapter(supportFragmentManager, lifecycle)
        TabLayoutMediator(tabLayout, viewPager){tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()

        var searchKeyword = intent.getStringExtra("searchTerm")
        viewBinding.etSearch.setText(searchKeyword)
        viewBinding.tvSearchTerm.text = searchKeyword
    }
}