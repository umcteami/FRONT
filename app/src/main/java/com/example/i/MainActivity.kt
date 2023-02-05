package com.example.i

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.i.signup.SignupActivity
import com.example.i.databinding.ActivityMainBinding
import com.example.i.login.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btnLogin.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            this.startActivity(intent)
        }

        viewBinding.btnJoin.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            this.startActivity(intent)
        }

        viewBinding.bt.setOnClickListener {
            val intent = Intent(this, Main2Activity::class.java)
            this.startActivity(intent)
        }

        // 계정 찾기로 이동
        viewBinding.findAccount.setOnClickListener {
            changeFragment(1)
        }
    }

    // 화면 이동
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
                    .replace(viewBinding.frameFragment.id, NewPwFragment())
                    .commit()
            }
        }
    }
}