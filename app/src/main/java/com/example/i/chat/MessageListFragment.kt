package com.example.i.chat

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.Main2Activity
import com.example.i.R
import com.example.i.chat.customdialog.MessageOptionDialog
import com.example.i.chat.model.ChatListInterface
import com.example.i.chat.model.ChatListResponse
import com.example.i.chat.model.ChatListService
import com.example.i.databinding.FragmentMessageListBinding

class MessageListFragment : Fragment(), ChatListInterface {
    private lateinit var viewBinding : FragmentMessageListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentMessageListBinding.inflate(layoutInflater)

        ChatListService(this).tryGetChatList(2)

        return viewBinding.root
    }

    override fun onGetChatListSuccess(response: ChatListResponse) {
        if (response.isSuccess) {
            val mList: ArrayList<Message> = arrayListOf()
            val adapter = MessageRVAdapter(mList)

            mList.apply {
                add(Message(response.result.profile,response.result.nick, response.result.recentChat, response.result.recentTime, response.result.noReadNum.toString()))
            }

            viewBinding.rvChat.layoutManager = LinearLayoutManager(requireActivity())
            viewBinding.rvChat.adapter = adapter

            adapter!!.itemClick = object : MessageRVAdapter.ItemClick{
                override fun onClick(view: View,  data: CharSequence, position: Int) {
                    val intent = Intent(context, MessageActivity::class.java)
                    intent.putExtra("memIdx", response.result.sender)
                    intent.putExtra("roomIdx", response.result.roomIdx)
                    startActivity(intent)
                }
            }

            adapter!!.itemLongClick = object : MessageRVAdapter.ItemLongClick{
                override fun onClick(view: View, position: Int) {
                    val dialog = MessageOptionDialog()
                    dialog.show(requireActivity().supportFragmentManager, "custom dialog")
                }
            }
        }
    }

    override fun onGetChatListFailure(message: String) {
        Log.d("error", "오류: $message")
    }
}