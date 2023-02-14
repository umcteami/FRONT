package com.example.i.community.search

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import com.example.i.community.customdialog.DiarySearchDialog
import com.example.i.community.customdialog.MarketSearchDialog
import com.example.i.community.customdialog.SearchDialog
import com.example.i.community.customdialog.StorySearchDialog
import com.example.i.community.search.ReviewSearchviewPagerAdapter
import com.example.i.community.search.searchVar.Companion.searchTerm
import com.example.i.databinding.ActivitySearchResultBinding
import com.google.android.material.tabs.TabLayoutMediator

class SearchResultActivity : AppCompatActivity(), View.OnClickListener {
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

        viewBinding.btChoiceCategory1.setOnClickListener(this)
        viewBinding.btChoiceCategory2.setOnClickListener(this)

        when(searchVar.searchRoom){
            0 -> {
                searchVar.searchBoard = 0
                viewBinding.tvChoiceCategory1.text = "아이홈"
                viewBinding.tvChoiceCategory2.text = "전체 게시글"
//                viewBinding.btChoiceCategory2.isEnabled = false
            }
            1 -> {
                viewBinding.tvChoiceCategory1.text = "이야기방"
                when(searchVar.searchBoard){
                    0 -> viewBinding.tvChoiceCategory2.text = "전체 게시글"
                    1 -> viewBinding.tvChoiceCategory2.text = "수다방"
                    2 -> viewBinding.tvChoiceCategory2.text = "질문방"
                    3 -> viewBinding.tvChoiceCategory2.text = "정보방"
                }
            }
            2 -> {
                viewBinding.tvChoiceCategory1.text = "일기장"
                when(searchVar.searchBoard){
                    0 -> viewBinding.tvChoiceCategory2.text = "전체 게시글"
                    1 -> viewBinding.tvChoiceCategory2.text = "간호 일기"
                    2 -> viewBinding.tvChoiceCategory2.text = "무지개 일기"
                }
            }
            3 -> {
                searchVar.searchBoard = 0
                viewBinding.tvChoiceCategory1.text = "장터후기"
                viewBinding.tvChoiceCategory2.text = "전체 게시글"
//                viewBinding.btChoiceCategory2.isEnabled = false
            }
            4 -> {
                viewBinding.tvChoiceCategory1.text = "나눔장터"
                when(searchVar.searchBoard){
                    0 -> viewBinding.tvChoiceCategory2.text = "전체 게시글"
                    1 -> viewBinding.tvChoiceCategory2.text = "맘마/까까"
                    2 -> viewBinding.tvChoiceCategory2.text = "장난감"
                    3 -> viewBinding.tvChoiceCategory2.text = "영양제/약/간호용품"
                    4 -> viewBinding.tvChoiceCategory2.text = "기타"
                }
            }


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

    override fun onClick(view: View?) {
        when(view?.id){
            viewBinding.btChoiceCategory1.id ->{
                val dlg = SearchDialog(this)
                dlg.setOnOkClickedListener { content ->
                    viewBinding.tvChoiceCategory1.text = content
                    when(content){
                        "아이홈" -> {
                            searchVar.searchRoom = 0
                            searchVar.searchBoard = 0
//                            viewBinding.btChoiceCategory2.isEnabled = false
                            viewBinding.tvChoiceCategory2.text = "전체 게시글"
                            refresh()
                        }
                        "이야기방" -> {
                            searchVar.searchRoom = 1
                            searchVar.searchBoard = 0
                            refresh()
                        }
                        "일기장" -> {
                            searchVar.searchRoom = 2
                            searchVar.searchBoard = 0
                            refresh()
                        }
                        "장터후기" -> {
                            searchVar.searchRoom = 3
                            searchVar.searchBoard = 0
//                            viewBinding.btChoiceCategory2.isEnabled = false
                            viewBinding.tvChoiceCategory2.text = "전체 게시글"
                            refresh()
                        }
                        "나눔장터" -> {
                            searchVar.searchRoom = 4
                            searchVar.searchBoard = 0
                            refresh()
                        }
                    }
                }
                dlg.show()
            }

            viewBinding.btChoiceCategory2.id ->{
                when(searchVar.searchRoom){
                    0 -> {
                        viewBinding.tvChoiceCategory2.text = "전체 게시글"
                    }
                    1 -> {
                        val dlg2 = StorySearchDialog(this)
                        dlg2.setOnOkClickedListener { content ->
                            viewBinding.tvChoiceCategory2.text = content
                            when(content){
                                "전체 게시글" -> {
                                    searchVar.searchBoard = 0
                                    refresh()
                                }
                                "수다방" -> {
                                    searchVar.searchBoard = 1
                                    refresh()
                                }
                                "질문방" -> {
                                    searchVar.searchBoard = 2
                                    refresh()
                                }
                                "정보방" -> {
                                    searchVar.searchBoard = 3
                                    refresh()
                                }
                            }
                        }
                        dlg2.show()
                    }
                    2 -> {
                        val dlg2 = DiarySearchDialog(this)
                        dlg2.setOnOkClickedListener { content ->
                            viewBinding.tvChoiceCategory2.text = content
                            when(content){
                                "전체 게시글" -> {
                                    searchVar.searchBoard = 0
                                    refresh()
                                }
                                "간호 일기" -> {
                                    searchVar.searchBoard = 1
                                    refresh()
                                }
                                "무지개 일기" -> {
                                    searchVar.searchBoard = 2
                                    refresh()
                                }
                            }
                        }
                        dlg2.show()
                    }
                    3 -> {
                        viewBinding.tvChoiceCategory2.text = "전체 게시글"
                    }
                    4 -> {
                        val dlg2 = MarketSearchDialog(this)
                        dlg2.setOnOkClickedListener { content ->
                            viewBinding.tvChoiceCategory2.text = content
                            when(content){
                                "전체 게시글" -> {
                                    searchVar.searchBoard = 0
                                    refresh()
                                }
                                "맘마/까까" -> {
                                    searchVar.searchBoard = 1
                                    refresh()
                                }
                                "장난감" -> {
                                    searchVar.searchBoard = 2
                                    refresh()
                                }
                                "영양제/약/간호용품" -> {
                                    searchVar.searchBoard = 3
                                    refresh()
                                }
                                "기타" -> {
                                    searchVar.searchBoard= 4
                                    refresh()
                                }
                            }
                        }
                        dlg2.show()
                    }
                }
//                refresh()
            }
        }
    }
    fun refresh(){
        val searchTerm = viewBinding.etSearch.text.toString()
        val searchIntent = Intent(this, SearchResultActivity::class.java)
        searchIntent.putExtra("searchTerm", "$searchTerm")
        startActivity(searchIntent)
        finish()
    }
}

class searchVar(){
    companion object{
        var searchRoom : Int = 0
        var searchBoard : Int = 0
        var searchTerm : String? = ""
    }
}

