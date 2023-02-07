package com.example.i.community

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.KeyEvent.KEYCODE_ENTER
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import com.example.i.community.review.ReviewSearchActivity
import com.example.i.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btnSearch.setOnClickListener{
            supportFragmentManager
                .beginTransaction()
                .replace(viewBinding.frameFragment.id, SearchResultFragment())
                .commitAllowingStateLoss()
        }

        viewBinding.etSearch.setOnEditorActionListener{_, actionId, event->
            if(actionId == EditorInfo.IME_ACTION_DONE ){
                val intent = Intent(this, ReviewSearchActivity::class.java)
                startActivity(intent)
                true
            }
            else{
                false
            }
        }
    }
}