package com.example.i.chat

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.Main2Activity
import com.example.i.R
import com.example.i.chat.customdialog.MessageOptionDialog
import com.example.i.databinding.FragmentMessageListBinding

class MessageListFragment : Fragment() {
    private lateinit var viewBinding : FragmentMessageListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentMessageListBinding.inflate(layoutInflater)

        val activity = activity as Main2Activity

        val mList: ArrayList<Message> = arrayListOf()
        val adapter = MessageRVAdapter(mList)

        mList.apply{
            add(Message("Summer", "멀고도 험한 개발의 길", "19:00",""))
            add(Message("아이", "새해 복 많이 받으세요.", "20:00", "3"))
            add(Message("아이", "새해 복 많이 받으세요.", "20:00", "3"))
            add(Message("아이", "새해 복 많이 받으세요.", "20:00", "3"))
            add(Message("아이", "새해 복 많이 받으세요.", "20:00", "3"))
            add(Message("아이", "새해 복 많이 받으세요.", "20:00", "3"))
            add(Message("아이", "새해 복 많이 받으세요.", "20:00", "3"))
            add(Message("아이", "새해 복 많이 받으세요.", "20:00", "3"))
            add(Message("아이", "새해 복 많이 받으세요.", "20:00", "3"))
        }

        viewBinding.rvChat.layoutManager = LinearLayoutManager(context)
        viewBinding.rvChat.adapter = adapter

        adapter!!.itemClick = object : MessageRVAdapter.ItemClick{
            override fun onClick(view: View,  data: CharSequence, position: Int) {
                val intent = Intent(context, MessageActivity::class.java)
                intent.putExtra("nickname", data)
                startActivity(intent)
            }
        }

        adapter!!.itemLongClick = object : MessageRVAdapter.ItemLongClick{
            override fun onClick(view: View, position: Int) {
                val dialog = MessageOptionDialog()
                dialog.show(activity.supportFragmentManager, "custom dialog")
            }
        }

        return viewBinding.root
    }
}