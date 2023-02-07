package com.example.i.signup.customdialog

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.i.databinding.DialogNicknameBinding
import com.example.i.signup.SignupActivity

class NicknameDialog(): DialogFragment() {
    private lateinit var viewBinding: DialogNicknameBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DialogNicknameBinding.inflate(inflater, container, false)

        val signup = activity as SignupActivity

        viewBinding.tvLimit.text = "닉네임 변경은 3회로 제한됩니다.\n설정을 완료하시겠습니까?"

        viewBinding.btYes.setOnClickListener {
            signup.changeFragment(6)
            dialog?.dismiss()
        }

        viewBinding.btNo.setOnClickListener {
            dialog?.dismiss()
        }


        return viewBinding.root
    }
}