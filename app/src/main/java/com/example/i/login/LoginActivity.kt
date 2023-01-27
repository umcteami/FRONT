package com.example.i.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.i.Main2Activity
import com.example.i.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        // 메인 화면으로 이동
        viewBinding.btLogin.setOnClickListener {
              val intent = Intent(this, Main2Activity::class.java)
             this.startActivity(intent)
        }

        // 계정 찾기로 이동
        viewBinding.findAccount.setOnClickListener {
            changeFragment(1)
        }

        // 비밀번호 재설정으로 이동
        viewBinding.newPwd.setOnClickListener {
            changeFragment(2)
        }
    }

    fun changeFragment(index: Int){
        when(index){
            // 계정 찾기
            1 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(viewBinding.frameFragment.id, AccountSearchFragment())
                    .commit()
            }
            // 비번 찾기
            2 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(viewBinding.frameFragment.id, PwSearchFragment())
                    .commit()
            }
            // 인증번호 받기
            3 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(viewBinding.frameFragment.id, AccountCodeFragment())
                    .commit()
            }
            // 이메일 확인
            4 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(viewBinding.frameFragment.id, CodeCorrectFragment())
                    .commit()
            }
            // 인증번호 받기
            5 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(viewBinding.frameFragment.id, PwCodeFragment())
                    .commit()
            }
            // 비번 재설정
            6 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(viewBinding.frameFragment.id, NewPWFragment())
                    .commit()
            }
        }
    }
}

