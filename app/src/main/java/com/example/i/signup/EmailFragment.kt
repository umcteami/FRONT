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
import com.example.i.databinding.FragmentEmailBinding
import com.example.i.signup.models.*


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
            val auth = viewBinding.etEmail.text.toString()
            val EmailRequest = PostCodeRequest(type = 1, auth = auth)
            PostCodeService(this).tryPostEmail(EmailRequest)

            // Activity.changeFragment(1)
        }

        return viewBinding.root
    }

    // 서버 연결 성공
    override fun onPostEmailSuccess(response: CodeResponse) {
        // 인증번호 발송이 성공한 경우
        if(response.isSuccess){
            val Activity = activity as SignupActivity
            Activity.changeFragment(1)

//            // 사용자가 입력한 email 전달
//            val bundle = Bundle() // 번들을 통해 값 전달
//            bundle.putString("email", viewBinding.etEmail.text.toString()) //번들에 넘길 값 저장
//
//            val fragment2 = EmailCodeFragment() //프래그먼트2 선언
//            fragment2.setArguments(bundle) //번들을 프래그먼트2로 보낼 준비
//
//            requireActivity().supportFragmentManager
//                .beginTransaction()
//                .replace(viewBinding.frameFragment.id, fragment2)
//                .commit()
        }

        // Result message
        Toast.makeText(activity,response.message,Toast.LENGTH_SHORT).show()
    }

    // 서버 연결 실패
    override fun onPostEmailFailure(message: String) {
        Toast.makeText(activity, "오류 : $message", Toast.LENGTH_SHORT).show()
    }

    override fun onPostPhoneSuccess(response: CodeResponse) {
        TODO("Not yet implemented")
    }

    override fun onPostPhoneFailure(message: String) {
        TODO("Not yet implemented")
    }
}