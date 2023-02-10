package com.example.i.login

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.i.databinding.FragmentPwSearchBinding

var email : String = "" // 전역 변수

class PwSearchFragment : Fragment() {

    private lateinit var viewBinding: FragmentPwSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentPwSearchBinding.inflate(inflater, container, false)

        val activity = activity as AccountSearchActivity

        viewBinding.btCall.isEnabled = false

        viewBinding.etEmail.addTextChangedListener(object: TextWatcher {
            // 입력 전
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            // 입력 중
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var ecode = viewBinding.etEmail.text.toString()
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
            email = viewBinding.etEmail.text.toString()
            activity.changeFragment(5)
        }
        return viewBinding.root
    }
}