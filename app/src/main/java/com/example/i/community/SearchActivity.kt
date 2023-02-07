package com.example.i.community

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.KeyEvent.KEYCODE_ENTER
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.Toast
import com.example.i.community.review.ReviewSearchActivity
import com.example.i.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivitySearchBinding
    private val SEARCH_REQUEST = 1

    private fun search(searchTerm : String){
        val searchIntent = Intent(this, SearchResultActivity::class.java)
        intent.putExtra("search_term", searchTerm)
        startActivityForResult(searchIntent, SEARCH_REQUEST)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

//        viewBinding.btnSearch.setOnClickListener{
//            supportFragmentManager
//                .beginTransaction()
//                .replace(viewBinding.frameFragment.id, SearchResultFragment())
//                .commitAllowingStateLoss()
//        }

        viewBinding.chip1.setOnClickListener{
            search(viewBinding.chip1.toString())
        }
        viewBinding.chip1.setOnCloseIconClickListener{
            
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
}