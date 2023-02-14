package com.example.i.login

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.i.MainActivity
import com.example.i.config.BaseResponse
import com.example.i.databinding.FragmentNewPwBinding
import com.example.i.login.models.PostNewPwRequest

class NewPwFragment : Fragment(), NewPwInterface {

    private lateinit var viewBinding: FragmentNewPwBinding
    private var pw: String = ""
    private var pwcode: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentNewPwBinding.inflate(inflater, container, false)

        viewBinding.btOk.isEnabled = false

        viewBinding.etPw.addTextChangedListener(object: TextWatcher {
            // 입력 전
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            // 입력 중
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                pw = viewBinding.etPw.text.toString()
                pwcode = viewBinding.etPwcode.text.toString()

                viewBinding.btOk.isEnabled = pw.isNotEmpty() && pwcode.isNotEmpty()

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

        viewBinding.etPwcode.addTextChangedListener(object: TextWatcher {
            // 입력 전
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            // 입력 중
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                pw = viewBinding.etPw.text.toString()
                pwcode = viewBinding.etPwcode.text.toString()

                viewBinding.btOk.isEnabled = pw.isNotEmpty() && pwcode.isNotEmpty()

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

        viewBinding.btOk.setOnClickListener{

            // 비밀번호 확인
            if (!checkPw()) {
                return@setOnClickListener
            }

            val pw = viewBinding.etPwcode.text.toString()
            val NewPwRequest = PostNewPwRequest(email = pwEmail, pw = pw)
            NewPwService(this).tryPatchNewPw(NewPwRequest)

            val loginPwRequest = PostNewPwRequest(email = loginEmail, pw = pw)
            NewPwService(this).tryPatchNewPw(loginPwRequest)
        }

        return viewBinding.root
    }

    // 서버 연결 성공
    override fun onPatchNewPwSuccess(response: BaseResponse) {

        // 계정이 있는 경우
        if(response.isSuccess){
            // 메인 화면으로 이동
            activity?.let{
                val intent = Intent(context, MainActivity::class.java)
                startActivity(intent)
            }
        }
        // Result message
        response.message!!.let { Toast.makeText(activity, it, Toast.LENGTH_SHORT).show() }
    }

    // 서버 연결 실패
    override fun onPatchNewPwFailure(message: String) {
        Toast.makeText(activity, "오류 : $message", Toast.LENGTH_SHORT).show()
    }

    // 비밀번호 확인
    fun checkPw() : Boolean {
        val newPwd = viewBinding.newPwd.editText?.text.toString()
        val checkPw = viewBinding.checkPw.editText?.text.toString()

        // 비밀번호 확인
        return if (newPwd != checkPw) {
            viewBinding.checkPw.error = "비밀번호가 일치하지 않습니다"
            false
        }
        // 에러가 없는 경우
        else {
            viewBinding.checkPw.error = null
            viewBinding.checkPw.isErrorEnabled = false // 에러 메시지 사용X
            true
        }
    }
}