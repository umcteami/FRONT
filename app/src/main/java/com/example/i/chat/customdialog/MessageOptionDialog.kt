package com.example.i.chat.customdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.i.Main2Activity
import com.example.i.databinding.DialogMessageOptionBinding

class MessageOptionDialog: DialogFragment() {
    private lateinit var viewBinding: DialogMessageOptionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DialogMessageOptionBinding.inflate(inflater, container, false)

        viewBinding.btAlarm.setOnClickListener {
            Toast.makeText(requireActivity(), "알람끄기", Toast.LENGTH_SHORT).show()
            dialog?.dismiss()

        }

        viewBinding.btBan.setOnClickListener {
            Toast.makeText(requireActivity(), "차단하기", Toast.LENGTH_SHORT).show()
            dialog?.dismiss()
        }

        viewBinding.btEnd.setOnClickListener {
            val dlg = MessageNoticeDialog()
            dlg.show(requireActivity().supportFragmentManager, "custom dialog")
            dialog?.dismiss()
        }

        return viewBinding.root
    }
}