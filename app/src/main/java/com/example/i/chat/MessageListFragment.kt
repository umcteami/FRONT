package com.example.i.chat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.databinding.FragmentMessageListBinding

class MessageListFragment : Fragment() {
    private lateinit var viewBinding : FragmentMessageListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentMessageListBinding.inflate(layoutInflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mList: ArrayList<Message> = arrayListOf()

        mList.apply{
            add(Message("Summer", "멀고도 험한 개발의 길", "19:00",""))
            add(Message("아이", "새해 복 많이 받으세요.", "20:00", "3"))
        }

        viewBinding.rvChat.layoutManager = LinearLayoutManager(context)
        viewBinding.rvChat.adapter = MessageRVAdapter(mList)
    }
}