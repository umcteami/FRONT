package com.example.i.signup

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.i.MainActivity
import com.example.i.databinding.FragmentEmailCodeBinding
import com.example.i.signup.models.*


class EmailCodeFragment : Fragment(), GetEmailInterface {
    private lateinit var viewBinding : FragmentEmailCodeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentEmailCodeBinding.inflate(inflater, container, false)

        // 데이터 불러오기
        if (getArguments() != null)
        {
            val email = getArguments()?.getString("email"); // 프래그먼트1에서 받아온 값 넣기
            viewBinding.tvEmail.text = email
        }

        viewBinding.backBtn.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }

        viewBinding.btOk.isEnabled = false

        viewBinding.etEmailCode.addTextChangedListener(object: TextWatcher {
            // 입력 전
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            // 입력 중
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var ecode = viewBinding.etEmailCode.text.toString()
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

        viewBinding.btOk.setOnClickListener{
            GetEmailService(this).tryGetEmail(authIdx)
            Toast.makeText(activity,"authIdx : {$authIdx}",Toast.LENGTH_SHORT).show()
        }

        return viewBinding.root

    }

    override fun onGetEmailSuccess(response: EmailCheckResponse) {
        // 계정이 있는 경우
        if(response.isSuccess){
            // 인증번호 발송이 성공한 경우
            val Activity = activity as SignupActivity
            Activity.changeFragment(2)
        }

        // Result message
        Toast.makeText(activity,response.message,Toast.LENGTH_SHORT).show()
    }

    // 서버 연결 실패
    override fun onGetEmailFailure(message: String) {
        Toast.makeText(activity, "오류 : $message", Toast.LENGTH_SHORT).show()
    }
}