package com.example.i

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.i.databinding.FragmentTalkroomBinding


class TalkroomFragment1 : Fragment() {
    private lateinit var binding : FragmentTalkroomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val rv_board = binding.rvBoard
        val itemList = ArrayList<BoardItem>()

        itemList.add(BoardItem("12:00", "안녕하세요 회원 여러분","삐삐엄마", 12,"2", "3","자유방"))

        val communityBoardAdapter = CommunityBoardAdapter(itemList)
        communityBoardAdapter.notifyDataSetChanged()

        rv_board.adapter = communityBoardAdapter

        arguments?.let {
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTalkroomBinding.inflate(inflater, container, false)
        return binding.root
    }
}