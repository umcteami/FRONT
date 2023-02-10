package com.example.i.mypage.customdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.i.databinding.DialogNicknameBinding
import com.example.i.mypage.MypageSettingActivity

class PopupOutDialog: DialogFragment() {
    private lateinit var viewBinding: DialogNicknameBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DialogNicknameBinding.inflate(inflater, container, false)
        val setting = activity as MypageSettingActivity

        viewBinding.tvLimit.text = "수정사항을 저장하지 않고 나가시겠습니까?"

        viewBinding.btYes.setOnClickListener {
            dialog?.dismiss()
            setting.finish()
        }

        viewBinding.btNo.setOnClickListener {
            dialog?.dismiss()
        }

        return viewBinding.root
    }
}