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

var accountEmail : String = "" // 전역 변수

class AccountCodeFragment : Fragment(), FindInterface {

    private lateinit var viewBinding: FragmentAccountCodeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentAccountCodeBinding.inflate(inflater, container, false)

        viewBinding.btOk.isEnabled = false
        viewBinding.tvPhone.text = phone // 데이터 가져오기

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
            val Activity = activity as AccountSearchActivity
            Activity.changeFragment(4)

            FindService(this).tryGetFind(phone) // 이메일 찾기 API
        }

        return viewBinding.root
    }

    // 이메일 찾기 API
    override fun onGetFindSuccess(response: FindResponse) {
        // 인증번호 발송이 성공한 경우
        if(response.isSuccess){
            val Activity = activity as AccountSearchActivity
            Activity.changeFragment(4)

            if(response.result != null)
            {
                accountEmail = response.result.toString() //이메일 가져오기
            }
            else
            {   accountEmail = "가입하신 이메일 주소가 없습니다."    }
        }
        // Result message
        Toast.makeText(activity,response.message,Toast.LENGTH_SHORT).show()
    }

    // 서버 연결 실패
    override fun onGetFindFailure(message: String) {
        Log.d("error", "오류 : $message")
    }
}