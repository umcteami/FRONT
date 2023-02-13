package com.example.i.chat

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.chat.customdialog.MessageNoticeDialog
import com.example.i.chat.customdialog.MessageOptionDialog
import com.example.i.chat.model.ChatListInterface
import com.example.i.chat.model.ChatListResponse
import com.example.i.chat.model.ChatListService
import com.example.i.databinding.FragmentMessageListBinding
import com.example.i.market.MarketMainFragment

class MessageListFragment : Fragment(), ChatListInterface {
    private lateinit var viewBinding : FragmentMessageListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentMessageListBinding.inflate(layoutInflater)

        ChatListService(this).tryGetChatList(8)

        return viewBinding.root
    }

    override fun onGetChatListSuccess(response: ChatListResponse) {
        if (response.isSuccess) {
            val mList: ArrayList<Message> = arrayListOf()
            val adapter = MessageRVAdapter(mList)
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
                    intent.putExtra("memIdx", 8)
                    intent.putExtra("roomIdx", response.result[position].roomIdx)
                    intent.putExtra("nick", response.result[position].nick)
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