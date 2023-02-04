package com.example.i.login

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.i.Main2Activity
import com.example.i.MainActivity
import com.example.i.databinding.ActivityLoginBinding
import com.example.i.login.models.LoginResponse
import com.example.i.login.models.PostLoginRequest


class LoginActivity : AppCompatActivity(), LoginInterface {
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

        // 계정 찾기로 이동
        viewBinding.findAccount.setOnClickListener {
            changeFragment(1)
        }

        // 비밀번호 재설정으로 이동
        viewBinding.newPwd.setOnClickListener {
            changeFragment(2)
        }

        viewBinding.btLogin.isEnabled = false

        viewBinding.loginEtPw.addTextChangedListener(object: TextWatcher {
            // 입력 전
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            // 입력 중
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var login = viewBinding.loginEtPw.text.toString()
                viewBinding.btLogin.isEnabled = login.isNotEmpty()

                if (viewBinding.btLogin.isEnabled == false) {
                    viewBinding.btLogin.setTextColor(Color.rgb(0x6B,0x66,0x66))
                }
                else {
                    viewBinding.btLogin.setTextColor(Color.WHITE)
                }
            }

            // 입력 후
            override fun afterTextChanged(p0: Editable?) {
            }

        })

        // 로그인
        viewBinding.btLogin.setOnClickListener {

            // 이메일 확인
            if (!validateEmail()) {
                return@setOnClickListener
            }

            // 서버에 값 보냄
            val email = viewBinding.loginEtId.text.toString()
            val password = viewBinding.loginEtPw.text.toString()
            val postRequest = PostLoginRequest(email = email, password = password)
            LoginService(this).tryPostLogin(postRequest)
        }
    }

    // 서버 연결 성공
    override fun onPostLoginSuccess(response: LoginResponse) {

        // 계정이 있는 경우
        if(response.isSuccess){
            // 메인 화면으로 이동
            val intent = Intent(this, Main2Activity::class.java)
            this.startActivity(intent)
        }

        // Result message
        response.message?.let { Toast.makeText(this, it, Toast.LENGTH_SHORT).show() }
    }

    // 서버 연결 실패
    override fun onPostLoginFailure(message: String) {
        Toast.makeText(this, "오류 : $message", Toast.LENGTH_SHORT).show()
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

