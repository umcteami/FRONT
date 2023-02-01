package com.example.i.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.i.Main2Activity
import com.example.i.MainActivity
import com.example.i.R
import com.example.i.community.ReviewWriteActivity
import com.example.i.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        //툴바 뒤로가기 -> 첫 화면으로 이동
        val buttonWrite = viewBinding.backBtn
        buttonWrite.setOnClickListener {
            val writeIntent = Intent(this, MainActivity::class.java)
            startActivity(writeIntent)
        }

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

        // 로그인
        viewBinding.btLogin.setOnClickListener {

//            // 이메일 확인
//            if (!validateEmail()) {
//                return@setOnClickListener
//            }

            // 메인 화면으로 이동
            val intent = Intent(this, Main2Activity::class.java)
            this.startActivity(intent)
            Toast.makeText(this, "Welcome!", Toast.LENGTH_SHORT).show()
        }
    }

    // 이메일 확인
    fun validateEmail(): Boolean {
        val value = viewBinding.idLayout.editText?.text.toString()
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+" // 이메일 형식

        // 이메일 입력이 안된 경우
        return if (value.isEmpty()) {
            viewBinding.idLayout.error = "이메일을 입력해주세요."
            false
        }
        // 이메일 형식이 잘못된 경우
        else if (!value.matches(emailPattern.toRegex())) {
            viewBinding.idLayout.error = "이메일 형식이 잘못되었습니다."
            false
        }
        // 에러가 없는 경우
        else {
            viewBinding.idLayout.error = null
            viewBinding.idLayout.isErrorEnabled = false // 에러 메시지 사용X
            true
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

