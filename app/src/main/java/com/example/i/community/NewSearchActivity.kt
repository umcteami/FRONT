package com.example.i.community

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.Toast
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
//                Toast.makeText(this,"Search를 누름",Toast.LENGTH_SHORT).show()
                val searchTerm = viewBinding.etSearch.text.toString()
                val searchIntent = Intent(this, SearchResultActivity::class.java)
                searchIntent.putExtra("searchTerm", "$searchTerm")
                startActivity(searchIntent)
                finish()
                return@setOnEditorActionListener true
            }
            else{
                Toast.makeText(this,"Search를 잘못 누름",Toast.LENGTH_SHORT).show()
                false
            }

        }
    }
}