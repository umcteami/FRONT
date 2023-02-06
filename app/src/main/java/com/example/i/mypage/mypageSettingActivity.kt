package com.example.i.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.i.databinding.ActivityMypageSettingBinding



class mypageSettingActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMypageSettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMypageSettingBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        //툴바 뒤로가기 -> 첫 화면으로 이동
       viewBinding.backBtn.setOnClickListener {
            finish()
        }


        viewBinding.editPwd.setOnClickListener {

        }


    }

}