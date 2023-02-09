package com.example.i.mypage.customdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.i.databinding.DialogNicknameBinding
import com.example.i.mypage.MypageSettingActivity

class PopupSaveDialog: DialogFragment() {

    private lateinit var viewBinding: DialogNicknameBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DialogNicknameBinding.inflate(inflater, container, false)

        var activity = activity as MypageSettingActivity

        viewBinding.tvLimit.text = "저장하시겠습니까?\n(닉네임은 3회까지만 변경이 가능합니다)"

        viewBinding.btYes.setOnClickListener {
            activity.serverConnect()
            dialog?.dismiss()
        }

        viewBinding.btNo.setOnClickListener {
            var dlg = PopupOutDialog()
            dlg.show(activity.supportFragmentManager,"custom dialog")
            dialog?.dismiss()

        }

        return viewBinding.root
    }
}