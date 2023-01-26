package com.example.i.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.i.R
import com.example.i.databinding.ActivityMypageSettingBinding

class mypageSetting : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMypageSettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMypageSettingBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        setSupportActionBar(viewBinding.mypageSettingToolbar)
        //Toolbar에 표시되는 제목의 표시 유무를 설정. false로 해야 custom한 툴바의 이름이 화면에 보인다.
        supportActionBar?.setDisplayShowTitleEnabled(true)
        //왼쪽 버튼 사용설정(기본은 뒤로가기)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        //왼쪽 버튼 아이콘 변경
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_back) //위치 조정 어케하지

//        viewBinding.settingSaveBtn.setOnClickListener { //저장버튼


//
//        }

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