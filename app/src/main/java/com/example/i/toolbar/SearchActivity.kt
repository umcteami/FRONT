package com.example.i.toolbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.R
import com.example.i.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        setSupportActionBar(viewBinding.searchToolbar)
        //Toolbar에 표시되는 제목의 표시 유무를 설정. false로 해야 custom한 툴바의 이름이 화면에 보인다.
        supportActionBar?.setDisplayShowTitleEnabled(false)
        //왼쪽 버튼 사용설정(기본은 뒤로가기)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        //왼쪽 버튼 아이콘 변경
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_back) //위치 조정 어케하지

        val searchList: ArrayList<Search> = arrayListOf()

        searchList.apply {
            add(Search("1.","강아지 간식"))
            add(Search("1.","강아지 간식"))
            add(Search("1.","강아지 간식"))
            add(Search("1.","강아지 간식"))
            add(Search("1.","강아지 간식"))
            add(Search("1.","강아지 간식"))
            add(Search("1.","강아지 간식"))
            add(Search("1.","강아지 간식"))
        }
        val searchRVAdapter = SearchRVAdapter(searchList)
        viewBinding.searchRV.adapter = searchRVAdapter
        viewBinding.searchRV.layoutManager = LinearLayoutManager(this)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


}