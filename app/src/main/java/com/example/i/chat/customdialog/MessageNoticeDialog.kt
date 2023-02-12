package com.example.i.chat.customdialog

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.i.chat.model.ChatDeleteInterface
import com.example.i.chat.model.ChatDeleteRequest
import com.example.i.chat.model.ChatDeleteService
import com.example.i.config.BaseResponse
import com.example.i.databinding.DialogMessageNoticeBinding

class MessageNoticeDialog: DialogFragment(), ChatDeleteInterface {

    private lateinit var viewBinding: DialogMessageNoticeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DialogMessageNoticeBinding.inflate(inflater, container, false)

        viewBinding.btYes.setOnClickListener {
            var body = ChatDeleteRequest(roomIdx = 17, memIdx = 8)

            ChatDeleteService(this).tryPostChatDelete(body)
            dialog?.dismiss()
        }

        viewBinding.btNo.setOnClickListener {
            dialog?.dismiss()
        }

        return viewBinding.root
    }

    override fun onPostChatDeleteSuccess(response: BaseResponse) {
        if (response.isSuccess) {
            Log.d("success", "삭제 완료")
        }
    }

    override fun onPostChatDeleteFailure(message: String) {
        Log.d("error", "오류: $message")
    }


}