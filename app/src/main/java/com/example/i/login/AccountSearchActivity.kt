package com.example.i.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.i.databinding.ActivityAccountSearchBinding
import com.example.i.signup.EmailFragment

class AccountSearchActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityAccountSearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityAccountSearchBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        viewBinding.toolbar.setOnClickListener{
            finish()
        }

        var index = intent.getIntExtra("index", 1)

        changeFragment(index)

    }

    // 화면 이동
    fun changeFragment(index: Int){
        when(index){
            // 계정 찾기
            1 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(viewBinding.accountSearch.id, AccountSearchFragment())
                    .commitAllowingStateLoss()
            }
            // 비번 찾기
            2 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(viewBinding.accountSearch.id, PwSearchFragment())
                    .commitAllowingStateLoss()
            }
            // 인증번호 받기
            3 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(viewBinding.accountSearch.id, AccountCodeFragment())
                    .commit()
            }
            // 이메일 확인
            4 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(viewBinding.accountSearch.id, CodeCorrectFragment())
                    .commit()
            }
            // 인증번호 받기
            5 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(viewBinding.accountSearch.id, PwCodeFragment())
                    .commit()
            }
            // 비번 재설정
            6 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(viewBinding.accountSearch.id, NewPwFragment())
                    .commit()
            }
        }
    }
}