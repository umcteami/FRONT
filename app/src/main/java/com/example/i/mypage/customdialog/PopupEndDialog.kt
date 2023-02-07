package com.example.i.mypage.customdialog

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.i.Main2Activity
import com.example.i.MainActivity
import com.example.i.databinding.DialogNicknameBinding

class PopupEndDialog(var index: Int): DialogFragment() {

    private lateinit var viewBinding: DialogNicknameBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DialogNicknameBinding.inflate(inflater, container, false)

        val activity = activity as Main2Activity

        when (index) {
            1 -> {
                viewBinding.tvLimit.text = "로그아웃 하시겠습니까?"

                viewBinding.btYes.setOnClickListener {
                    val intent = Intent(activity, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                    dialog?.dismiss()
                    startActivity(intent)
                }

                viewBinding.btNo.setOnClickListener {
                    dialog?.dismiss()
                }
            }

            2 -> {
                viewBinding.tvLimit.text = "탈퇴하시겠습니까?"

                viewBinding.btYes.setOnClickListener {
                    val intent = Intent(activity, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                    dialog?.dismiss()
                    startActivity(intent)
                }

                viewBinding.btNo.setOnClickListener {
                    dialog?.dismiss()
                }
            }
        }

        return viewBinding.root
    }
}