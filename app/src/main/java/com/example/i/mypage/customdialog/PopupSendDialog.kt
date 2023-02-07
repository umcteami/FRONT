package com.example.i.mypage.customdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.i.databinding.DialogPopupSendBinding

class PopupSendDialog: DialogFragment() {

    private lateinit var viewBinding: DialogPopupSendBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DialogPopupSendBinding.inflate(inflater, container, false)

        viewBinding.btOk.setOnClickListener {
            dialog?.dismiss()
        }

        return viewBinding.root
    }
}