package com.example.i.community.customdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.i.databinding.DialogPostBinding

class DialogPost(var index: Int): DialogFragment() {

    private lateinit var viewBinding: DialogPostBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DialogPostBinding.inflate(inflater, container, false)

        when(index) {
            1 -> {
                viewBinding.tvLimit.text = "제목을 입력해주세요"
            }

            2 -> {
                viewBinding.tvLimit.text = "카테고리를 선택해주세요"
            }

            else -> {
                viewBinding.tvLimit.text = "내용을 입력해주세요"
            }
        }

        viewBinding.btYes.setOnClickListener {
            dialog?.dismiss()
        }

        return viewBinding.root
    }
}