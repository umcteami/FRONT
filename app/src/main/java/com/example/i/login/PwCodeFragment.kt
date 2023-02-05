package com.example.i.login

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.i.databinding.FragmentPwCodeBinding

class PwCodeFragment : Fragment() {
    private lateinit var viewBinding: FragmentPwCodeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentPwCodeBinding.inflate(inflater, container, false)

        val activity = activity as AccountSearchActivity

        viewBinding.btOk.isEnabled = false

        viewBinding.pwCode.addTextChangedListener(object: TextWatcher {
            // 입력 전
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            // 입력 중
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var ecode = viewBinding.pwCode.text.toString()
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

        //비번 재설정
        viewBinding.btOk.setOnClickListener{
            activity.changeFragment(6)
        }
        return viewBinding.root
    }
}