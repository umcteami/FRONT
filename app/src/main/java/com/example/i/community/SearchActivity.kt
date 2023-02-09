package com.example.i.community

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.Toast
import com.example.i.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var viewBinding: ActivitySearchBinding
    private var searchTerm : String = ""

    private fun search(searchTerm : String){
        val searchIntent = Intent(this, SearchResultActivity::class.java)
        intent.putExtra("search_term", searchTerm)
        startActivity(searchIntent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.chip1.setOnClickListener{
            search(viewBinding.chip1.toString())
        }
        viewBinding.btSearch.setOnClickListener{
//            searchTerm = viewBinding.etSearch.text.toString()
//            search(searchTerm)
            finish()
        }

        viewBinding.etSearch.setOnEditorActionListener{_, actionId, _->
            if(actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_SEARCH || EditorInfo.IME_ACTION_UNSPECIFIED == actionId)
            {
                Toast.makeText(this,"Search를 누름",Toast.LENGTH_SHORT).show()
                val searchTerm = viewBinding.etSearch.toString()
                search(searchTerm)
                return@setOnEditorActionListener true
            }
            else{
                Toast.makeText(this,"Search를 잘못 누름",Toast.LENGTH_SHORT).show()
                false
            }
        }
    }

    override fun onClick(view: View?) {
        when(view?.id){
            viewBinding.btSearch.id ->{
                finish()
            }
        }
    }
}