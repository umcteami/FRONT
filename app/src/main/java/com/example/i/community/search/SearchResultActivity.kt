package com.example.i.community.search

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import com.example.i.community.search.ReviewSearchviewPagerAdapter
import com.example.i.community.search.searchVar.Companion.searchTerm
import com.example.i.databinding.ActivitySearchResultBinding
import com.google.android.material.tabs.TabLayoutMediator

class SearchResultActivity : AppCompatActivity() {
    private lateinit var viewBinding : ActivitySearchResultBinding
    private var searchKeyword : String = ""
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

        when(viewBinding.btChoiceCategory1.toString()){
            "아이홈" -> searchVar.searchRoom = 0
            "이야기방" -> searchVar.searchRoom = 1
            "일기장" -> searchVar.searchRoom = 2
            "나눔장터" -> searchVar.searchRoom = 3
        }
        when(viewBinding.btChoiceCategory2.toString()){
            "전체 게시글" -> searchVar.searchBoard = 0
            "수다방" -> searchVar.searchBoard = 1
            "간호 일기" -> searchVar.searchBoard = 1
            "질문방" -> searchVar.searchBoard = 2
            "무지개 일기" -> searchVar.searchBoard = 2
            "정보방" -> searchVar.searchBoard = 3
        }

        viewBinding.etSearch.setOnEditorActionListener{_, actionId, _->
            if(actionId == EditorInfo.IME_ACTION_SEARCH)
            {
                val searchTerm = viewBinding.etSearch.text.toString()
                val searchIntent = Intent(this, SearchResultActivity::class.java)
                searchIntent.putExtra("searchTerm", "$searchTerm")
                startActivity(searchIntent)
                finish()
                return@setOnEditorActionListener true
            }
            else{
                Toast.makeText(this, "Search를 잘못 누름", Toast.LENGTH_SHORT).show()
                false
            }

        }

        viewPager.adapter = ReviewSearchviewPagerAdapter(supportFragmentManager, lifecycle)
        TabLayoutMediator(tabLayout, viewPager){tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()

        var searchKeyword = intent.getStringExtra("searchTerm")
        viewBinding.etSearch.setText(searchKeyword)
        viewBinding.tvSearchTerm.text = searchKeyword

        searchVar.searchTerm = searchKeyword
    }
}

class searchVar(){
    companion object{
        var searchRoom : Int = 0
        var searchBoard : Int = 0
        var searchTerm : String? = ""
    }
}