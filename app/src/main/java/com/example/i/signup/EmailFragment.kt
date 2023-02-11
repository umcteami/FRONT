package com.example.i.signup

import android.content.Intent
import android.content.SharedPreferences
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
import com.example.i.MainActivity
import com.example.i.databinding.FragmentEmailBinding
import com.example.i.signup.models.*
import retrofit2.Retrofit

var signUp_email : String = "" // 전역 변수
var authIdx : Int = 0 // 전역 변수

class EmailFragment : Fragment(), PostCodeInterface {

    private lateinit var viewBinding : FragmentEmailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentEmailBinding.inflate(inflater, container, false)

        viewBinding.backBtn.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }


        viewBinding.btOk.isEnabled = false

        viewBinding.etEmail.addTextChangedListener(object: TextWatcher{
            // 입력 전
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            // 입력 중
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var email = viewBinding.etEmail.text.toString()

                viewBinding.btOk.isEnabled = email.isNotEmpty()

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
            signUp_email = viewBinding.etEmail.text.toString()
            val EmailRequest = PostCodeRequest(type = 1, auth = signUp_email)
            PostCodeService(this).tryPostEmail(EmailRequest)
        }

        return viewBinding.root
    }

    // 서버 연결 성공
    override fun onPostEmailSuccess(response: CodeResponse) {
        // 인증번호 발송이 성공한 경우
        if(response.isSuccess){
            authIdx = response.result.authIdx
            val Activity = activity as? SignupActivity
            Activity?.changeFragment(1)
        }
        // Result message
        Toast.makeText(activity,response.message,Toast.LENGTH_SHORT).show()
    }

    // 서버 연결 실패
    override fun onPostEmailFailure(message: String) {
        Log.d("error", "오류 : $message")
    }

    override fun onPostPhoneSuccess(response: CodeResponse) {
        TODO("Not yet implemented")
    }

    override fun onPostPhoneFailure(message: String) {
        TODO("Not yet implemented")
    }
}