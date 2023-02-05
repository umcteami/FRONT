package com.example.i.login

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.example.i.R
import com.example.i.databinding.FragmentAccountSearchBinding

class AccountSearchFragment : Fragment(){
    private lateinit var viewBinding: FragmentAccountSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentAccountSearchBinding.inflate(inflater, container, false)

        val activity = activity as AccountSearchActivity

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
            activity.changeFragment(3)
        }
        return viewBinding.root
    }
}