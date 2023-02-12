package com.example.i.chat.customdialog

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.i.chat.model.ChatDeleteInterface
import com.example.i.chat.model.ChatDeleteRequest
import com.example.i.chat.model.ChatDeleteService
import com.example.i.config.BaseResponse
import com.example.i.databinding.DialogMessageNoticeBinding

class MessageNoticeDialog: DialogFragment(), ChatDeleteInterface {

    private lateinit var viewBinding: DialogMessageNoticeBinding
    var roomIdx: Int = 17
    var memIdx: Int = 8

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DialogMessageNoticeBinding.inflate(inflater, container, false)

        viewBinding.btYes.setOnClickListener {
            var body = ChatDeleteRequest(roomIdx = roomIdx, memIdx = memIdx)

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
           // MessageListFragment로 정보 전달
           Toast.makeText(requireActivity(), "채팅방이 삭제되었습니다.", Toast.LENGTH_SHORT).show()
       }
    }

    override fun onPostChatDeleteFailure(message: String) {
        Log.d("error", "오류: $message")
    }

}