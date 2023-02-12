package com.example.i.signup

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.i.MainActivity
import com.example.i.databinding.FragmentPasswordBinding

var signUp_pw : String = "" // 전역 변수

class PasswordFragment : Fragment() {
    private lateinit var viewBinding : FragmentPasswordBinding
    private var pwCheck: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentPasswordBinding.inflate(inflater, container, false)
        viewBinding.backBtn.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }

        val activity = activity as SignupActivity

        viewBinding.btOk.isEnabled = false

        viewBinding.etPwcheck.addTextChangedListener(object: TextWatcher {
            // 입력 전
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            // 입력 중
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                signUp_pw = viewBinding.etPw.text.toString()
                pwCheck = viewBinding.etPwcheck.text.toString()

                viewBinding.btOk.isEnabled = signUp_pw.isNotEmpty() && pwCheck.isNotEmpty()

                if (viewBinding.btOk.isEnabled == false) {
                    viewBinding.btOk.setTextColor(Color.rgb(0x6B,0x66,0x66))
                }
                else {
                    viewBinding.btOk.setTextColor(Color.WHITE)
                }
            }

            // 입력 후
            override fun afterTextChanged(p0: Editable?) {
            }

        })

        viewBinding.etPwcheck.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                signUp_pw = viewBinding.etPw.text.toString()
                pwCheck = viewBinding.etPwcheck.text.toString()

                viewBinding.btOk.isEnabled = signUp_pw.isNotEmpty() && pwCheck.isNotEmpty()

                if (viewBinding.btOk.isEnabled == false) {
                    viewBinding.btOk.setTextColor(Color.rgb(0x6B,0x66,0x66))
                }
                else {
                    viewBinding.btOk.setTextColor(Color.WHITE)
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        viewBinding.btOk.setOnClickListener{
            // 비밀번호 확인
            if (!checkPw()) {
                return@setOnClickListener
            }

            activity.changeFragment(5)
        }

        return viewBinding.root
    }

    // 비밀번호 확인
    fun checkPw() : Boolean {

        // 비밀번호 확인
        return if (signUp_pw != pwCheck) {
            viewBinding.tiPwcheck.error = "비밀번호가 일치하지 않습니다"
            false
        }
        // 에러가 없는 경우
        else {
            viewBinding.tiPwcheck.error = null
            viewBinding.tiPwcheck.isErrorEnabled = false // 에러 메시지 사용X
            true
        }
    }
}