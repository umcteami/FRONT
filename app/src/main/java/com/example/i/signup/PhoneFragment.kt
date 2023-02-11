package com.example.i.signup


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.i.MainActivity
import com.example.i.databinding.FragmentPhoneBinding
import com.example.i.signup.models.*

class PhoneFragment : Fragment(), PostCodeInterface {
    private lateinit var viewBinding : FragmentPhoneBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentPhoneBinding.inflate(inflater, container, false)

        viewBinding.backBtn.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }

        viewBinding.btOk.isEnabled = false

        viewBinding.etPhone.addTextChangedListener(object: TextWatcher {
            // 입력 전
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            // 입력 중
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var phone = viewBinding.etPhone.text.toString()
                viewBinding.btOk.isEnabled = phone.isNotEmpty()

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
            val auth = viewBinding.etPhone.text.toString()
            val PhoneRequest = PostCodeRequest(type = 2, auth = auth)
            PostCodeService(this).tryPostPhone(PhoneRequest)
        }

        return viewBinding.root
    }

    override fun onPostEmailSuccess(response: CodeResponse) {
    }

    override fun onPostEmailFailure(message: String) {
    }

    // 인증번호 발송 API
    override fun onPostPhoneSuccess(response: CodeResponse) {
        viewBinding.btOk.text = response.message

        // 인증번호 발송이 성공한 경우
        if(response.isSuccess){
            val Activity = activity as SignupActivity
            Activity.changeFragment(3)
        }
        // Result message
        Toast.makeText(activity,response.message, Toast.LENGTH_SHORT).show()
    }
    // 서버 연결 실패
    override fun onPostPhoneFailure(message: String) {
        Log.d("error", "오류 : $message")
    }
}