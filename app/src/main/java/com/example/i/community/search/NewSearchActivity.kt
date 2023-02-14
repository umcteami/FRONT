package com.example.i.community.search

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.i.databinding.ActivityNewSearchBinding

class NewSearchActivity : AppCompatActivity() {
    private lateinit var viewBinding : ActivityNewSearchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityNewSearchBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewBinding.etSearch.setOnEditorActionListener{_, actionId, _->
            if(actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_SEARCH || EditorInfo.IME_ACTION_UNSPECIFIED == actionId)
            {
                searchVar.searchBoard = 0
                searchVar.searchRoom = 0
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
    }
}