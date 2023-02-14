package com.example.i.chat.customdialog

import android.content.Context
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
    private lateinit var listener: CustomDialogListener

    var roomIdx: Int = 17
    var memIdx: Int = 8

    override fun onAttach(context: Context) {
        super.onAttach(context)

        listener = parentFragment as CustomDialogListener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DialogMessageNoticeBinding.inflate(inflater, container, false)

        viewBinding.btYes.setOnClickListener {

            listener.onDialogPositiveClick(this)
            var body = ChatDeleteRequest(roomIdx = roomIdx, memIdx = memIdx)
            ChatDeleteService(this).tryPostChatDelete(body)
            dialog?.dismiss()
        }

        viewBinding.btNo.setOnClickListener {
            listener.onDialogNegativeClick(this)
            dialog?.dismiss()
        }

        return viewBinding.root
    }

    override fun onPostChatDeleteSuccess(response: BaseResponse) {
       if (response.isSuccess) {
           // MessageListFragment로 정보 전달
       }
    }

    override fun onPostChatDeleteFailure(message: String) {
        Log.d("error", "오류: $message")
    }
}