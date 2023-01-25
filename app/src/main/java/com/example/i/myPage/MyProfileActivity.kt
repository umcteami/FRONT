package com.example.i.myPage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.i.databinding.ActivityMyProfileBinding

class MyProfileActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMyProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMyProfileBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        setSupportActionBar(viewBinding.toolbar)
        //Toolbar에 표시되는 제목의 표시 유무를 설정
        supportActionBar?.setDisplayShowTitleEnabled(false)
        //왼쪽 버튼 사용설정 (기본: 뒤로가기)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    //뒤로 가기 버튼 활성화
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