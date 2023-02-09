package com.example.i.community

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.i.databinding.ActivitySearchResultBinding

class SearchResultActivity : AppCompatActivity() {
    private lateinit var viewBinding : ActivitySearchResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySearchResultBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val searchTerm = intent.getStringExtra("searchTerm")
        viewBinding.etSearch.setText(searchTerm)
        viewBinding.tvSearchTerm.text = searchTerm


    }
}