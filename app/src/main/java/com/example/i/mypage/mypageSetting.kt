package com.example.i.mypage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.i.databinding.ActivityMypageSettingBinding



class mypageSetting : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMypageSettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMypageSettingBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        //툴바 뒤로가기 -> 첫 화면으로 이동
       viewBinding.backBtn.setOnClickListener {
            finish()
        }
    }

}