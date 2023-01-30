package com.example.i.toolbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.Main2Activity
import com.example.i.R
import com.example.i.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
//
        viewBinding.searchBackBtn.setOnClickListener {
            val intent = Intent(this, Main2Activity::class.java)
            intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }
        //
//        val searchList: ArrayList<Search> = arrayListOf()
//
//        searchList.apply {
//            add(Search("1.","강아지 간식"))
//            add(Search("1.","강아지 간식"))
//            add(Search("1.","강아지 간식"))
//            add(Search("1.","강아지 간식"))
//            add(Search("1.","강아지 간식"))
//            add(Search("1.","강아지 간식"))
//            add(Search("1.","강아지 간식"))
//            add(Search("1.","강아지 간식"))
//        }
//        val searchRVAdapter = SearchRVAdapter(searchList)
//        viewBinding.searchRV.adapter = searchRVAdapter
//        viewBinding.searchRV.layoutManager = LinearLayoutManager(this)
//
//    }
//
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