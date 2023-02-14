package com.example.i.login

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.i.databinding.FragmentAccountCodeBinding
import com.example.i.login.models.FindInterface
import com.example.i.login.models.FindResponse
import com.example.i.login.models.FindService
import com.example.i.signup.SignupActivity
import com.example.i.signup.models.EmailCheckResponse

var accountEmail : String = "" // 전역 변수

class AccountCodeFragment : Fragment(), FindInterface {

    private lateinit var viewBinding: FragmentAccountCodeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentAccountCodeBinding.inflate(inflater, container, false)

        viewBinding.btOk.isEnabled = false
        viewBinding.tvPhone.text = accountPhone // 데이터 가져오기

        viewBinding.etPhonecode.addTextChangedListener(object: TextWatcher {
            // 입력 전
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            // 입력 중
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var ecode = viewBinding.etPhonecode.text.toString()
                viewBinding.btOk.isEnabled = ecode.isNotEmpty()

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

        // 이메일 확인
        viewBinding.btOk.setOnClickListener{
            FindService(this).tryGetFind(accountPhone) // 이메일 찾기 API
        }

        return viewBinding.root
    }

    // 이메일 찾기 API
    override fun onGetFindSuccess(response: FindResponse) {
        if(response.isSuccess){

            val userCode = viewBinding.etPhonecode.text.toString()
            if(userCode == accountIdx.toString())
            {
                accountEmail = response.result

                // 다음 페이지로 이동
                val Activity = activity as AccountSearchActivity
                Activity.changeFragment(4)

                // Result message
                Toast.makeText(activity,response.message,Toast.LENGTH_SHORT).show()
            }
            else
            {
                viewBinding.inputPwd.error = "인증 번호가 틀렸습니다"
            }
        }
    }

    // 서버 연결 실패
    override fun onGetFindFailure(message: String) {
        Log.d("error", "오류 : $message")
    }
}