package com.example.i.chat.customdialog

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.i.databinding.DialogMessageOptionBinding

class MessageOptionDialog: DialogFragment() {
    private lateinit var viewBinding: DialogMessageOptionBinding
    private lateinit var listener: DialogListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DialogMessageOptionBinding.inflate(inflater, container, false)

        viewBinding.btAlarm.setOnClickListener {
            listener.alarmButtonClickListener(this)
            Log.d("alarm", "클릭 여부: alarm")
            dialog?.dismiss()
        }

        viewBinding.btBan.setOnClickListener {
            listener.banButtonClickListener(this)
            Log.d("alarm", "클릭 여부: ban")
            dialog?.dismiss()
        }

        viewBinding.btEnd.setOnClickListener {
            listener.endButtonClickListener(this)
            Log.d("alarm", "클릭 여부: end")
            dialog?.dismiss()
        }

        return viewBinding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        listener = parentFragment as DialogListener
    }

}