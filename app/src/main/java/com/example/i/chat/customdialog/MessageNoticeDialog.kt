package com.example.i.chat.customdialog

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.i.chat.model.ChatDeleteInterface
import com.example.i.chat.model.ChatDeleteRequest
import com.example.i.chat.model.ChatOutService
import com.example.i.config.BaseResponse
import com.example.i.databinding.DialogMessageNoticeBinding

var Jerry : Boolean = false // 전역변수

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
            ChatOutService(this).tryPostChatOut(body)
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
           Jerry()
           Log.d("Jerry", "클릭 여부1 : $Jerry")
       }
    }

    override fun onPostChatDeleteFailure(message: String) {
        Log.d("error", "오류: $message")
    }

    // 데이터 수정
    fun Jerry (){
        Jerry = true
    }
}