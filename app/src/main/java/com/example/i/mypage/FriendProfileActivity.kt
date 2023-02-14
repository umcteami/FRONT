package com.example.i.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.i.R
import com.example.i.databinding.ActivityFriendProfileBinding

class FriendProfileActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityFriendProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityFriendProfileBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        setSupportActionBar(viewBinding.toolbar)
        //Toolbar에 표시되는 제목의 표시 유무 설정
        supportActionBar?.setDisplayShowTitleEnabled(false)
        //왼쪽 버튼 사용설정 (기본: 뒤로가기)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
    //item 버튼 메뉴 Toolbar에 집어 넣기
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.profile_toolbar, menu)
        return true
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