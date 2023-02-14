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
import com.example.i.databinding.FragmentAccountSearchBinding
import com.example.i.login.models.PostPhoneInterface
import com.example.i.login.models.PostPhoneService
import com.example.i.signup.models.CodeResponse
import com.example.i.signup.models.PostCodeRequest

var accountPhone : String = "" // 전역 변수
var accountIdx : Int = 0 // 전역 변수

class AccountSearchFragment : Fragment(), PostPhoneInterface {
    private lateinit var viewBinding: FragmentAccountSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentAccountSearchBinding.inflate(inflater, container, false)

        viewBinding.btCall.isEnabled = false

        viewBinding.etPhone.addTextChangedListener(object: TextWatcher {
            // 입력 전
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            // 입력 중
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var ecode = viewBinding.etPhone.text.toString()
                viewBinding.btCall.isEnabled = ecode.isNotEmpty()

                if (viewBinding.btCall.isEnabled == false) {
                    viewBinding.btCall.setTextColor(Color.rgb(0x6B,0x66,0x66))
                }
                else {
                    viewBinding.btCall.setTextColor(Color.WHITE)
                }
            }

            // 입력 후
            override fun afterTextChanged(p0: Editable?) {
            }

        })

        //인증번호 받기
        viewBinding.btCall.setOnClickListener{

            accountPhone =  viewBinding.etPhone.text.toString()

            val PhoneRequest = PostCodeRequest(type = 2, auth = accountPhone)
            PostPhoneService(this).tryPostPhone(PhoneRequest)
        }
        return viewBinding.root
    }

    // 인증번호 발송 API
    override fun onPostPhoneSuccess(response: CodeResponse) {
        // 인증번호 발송이 성공한 경우
        if(response.isSuccess){
            val Activity = activity as AccountSearchActivity
            Activity.changeFragment(3)

            accountIdx = response.result.authIdx
        }
        // Result message
        Toast.makeText(activity,response.message, Toast.LENGTH_SHORT).show()
    }

    // 서버 연결 실패
    override fun onPostPhoneFailure(message: String) {
        Log.d("error", "오류 : $message")
    }
}