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
import com.example.i.login.NewPwFragment
import com.example.i.mypage.mypageSettingActivity

class PopupSaveDialog(var index: Int): DialogFragment() {

    private lateinit var viewBinding: DialogNicknameBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DialogNicknameBinding.inflate(inflater, container, false)

        var activity = activity as mypageSettingActivity

        when (index) {

            1 -> {
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
            }

            2 -> {
                viewBinding.tvLimit.text = "로그아웃 하시겠습니까?"

                viewBinding.btYes.setOnClickListener {
                    val intent = Intent(activity, MainActivity::class.java)
                    dialog?.dismiss()
                    startActivity(intent)
                }

                viewBinding.btNo.setOnClickListener {
                    dialog?.dismiss()
                }
            }

            else -> {
                viewBinding.tvLimit.text = "탈퇴 하시겠습니까?"

                viewBinding.btYes.setOnClickListener {
                    val intent = Intent(activity, MainActivity::class.java)
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