package com.example.i.mypage.customdialog

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.i.MainActivity
import com.example.i.databinding.DialogNicknameBinding
import com.example.i.mypage.RevokeActivity

class PopupRevokeDialog: DialogFragment() {
    private lateinit var viewBinding: DialogNicknameBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DialogNicknameBinding.inflate(inflater, container, false)

        val activity = activity as RevokeActivity

        viewBinding.tvLimit.text = "탈퇴하시겠습니까?"

        viewBinding.btYes.setOnClickListener {
            val intent = Intent(activity, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            dialog?.dismiss()
            startActivity(intent)
        }

        viewBinding.btNo.setOnClickListener {
            dialog?.dismiss()
            activity.finish()
        }

        return viewBinding.root
    }
}