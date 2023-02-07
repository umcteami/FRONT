package com.example.i.signup

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.i.MainActivity
import com.example.i.databinding.FragmentNicknameBinding
import com.example.i.signup.customdialog.NicknameDialog

class NicknameFragment : Fragment() {
    private lateinit var viewBinding : FragmentNicknameBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentNicknameBinding.inflate(inflater, container, false)

        viewBinding.backBtn.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }

        val activity = activity as SignupActivity

        viewBinding.btOk.isEnabled = false

        viewBinding.etNickname.addTextChangedListener(object: TextWatcher {
            // 입력 전
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            // 입력 중
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var nickname = viewBinding.etNickname.text.toString()

                viewBinding.btOk.isEnabled = nickname.isNotEmpty()

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
            val dialog = NicknameDialog()
            dialog.show(activity.supportFragmentManager, "Custom Dialog")
        }

        return viewBinding.root
    }
}