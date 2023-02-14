package com.example.i.chat

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.chat.customdialog.CustomDialogListener
import com.example.i.chat.customdialog.DialogListener
import com.example.i.chat.customdialog.MessageNoticeDialog
import com.example.i.chat.customdialog.MessageOptionDialog
import com.example.i.chat.model.ChatListInterface
import com.example.i.chat.model.ChatListResponse
import com.example.i.chat.model.ChatListService
import com.example.i.databinding.FragmentMessageListBinding
import com.example.i.login.memIdx


class MessageListFragment : Fragment(), ChatListInterface, CustomDialogListener, DialogListener {
    private lateinit var viewBinding : FragmentMessageListBinding
    val mList: ArrayList<Message> = arrayListOf()
    val adapter = MessageRVAdapter(mList)
    var listPosition: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentMessageListBinding.inflate(inflater, container, false)

        ChatListService(this).tryGetChatList(memIdx)

        return viewBinding.root
    }

    override fun onGetChatListSuccess(response: ChatListResponse) {
        if (response.isSuccess) {

            val customDecoration = ChatRVDecoration(2f, 2f, Color.rgb(0xB4,0xB4,0xB4))
            val index: Int = response.result.size - 1

            for (i in 0 .. index) {
                mList.apply {
                    add(
                        Message(
                            response.result[i]?.profile,
                            response.result[i]?.nick,
                            response.result[i]?.recentChat,
                            response.result[i]?.recentTime,
                            response.result[i]?.noReadNum.toString()
                        )
                    )
                }
            }

            viewBinding.rvChat.layoutManager = LinearLayoutManager(requireActivity())
            viewBinding.rvChat.adapter = adapter
            viewBinding.rvChat.addItemDecoration(customDecoration)

            adapter!!.itemClick = object : MessageRVAdapter.ItemClick{
                override fun onClick(view: View,  data: CharSequence, position: Int) {
                    val intent = Intent(context, MessageActivity::class.java)
                    intent.putExtra("roomIdx", response.result[position].roomIdx)
                    intent.putExtra("nick", response.result[position].nick)
                    startActivity(intent)
                }
            }

            adapter!!.itemLongClick = object : MessageRVAdapter.ItemLongClick{
                override fun onClick(view: View, position: Int) {
                    showOptionDialog()
                    listPosition = position
                }
            }
        }
    }

    private fun showOptionDialog() {
        val dialog = MessageOptionDialog()
        dialog.show(childFragmentManager, "customDialog")
    }

    private fun showNoticeDialog() {
        val dialog = MessageNoticeDialog()
        dialog.show(childFragmentManager, "customDialog")
    }

    override fun onGetChatListFailure(message: String) {
        Log.d("error", "오류: $message")
    }

    override fun onDialogPositiveClick(dialog: DialogFragment) {
        Log.d("test", "클릭 여부: $listPosition")
        mList.removeAt(listPosition)
        adapter.notifyDataSetChanged()
    }

    override fun onDialogNegativeClick(dialog: DialogFragment) {
        Log.d("test", "클릭 여부: no")
    }

    override fun alarmButtonClickListener(dialog: DialogFragment) {
        Log.d("test", "클릭 여부: messageAlarm")
    }

    override fun banButtonClickListener(dialog: DialogFragment) {
        Log.d("test", "클릭 여부: messageBan")
    }

    override fun endButtonClickListener(dialog: DialogFragment) {
        showNoticeDialog()
    }


}