package com.example.i.chat.customdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.i.databinding.DialogMessageNoticeBinding

class MessageNoticeDialog(): DialogFragment() {

    private lateinit var viewBinding: DialogMessageNoticeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DialogMessageNoticeBinding.inflate(inflater, container, false)

        viewBinding.btYes.setOnClickListener {

            dialog?.dismiss()
        }

        viewBinding.btNo.setOnClickListener {
            dialog?.dismiss()
        }

        return viewBinding.root
    }


}