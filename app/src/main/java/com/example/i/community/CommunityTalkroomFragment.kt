package com.example.i.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.databinding.FragmentTalkroomBinding

class CommunityTalkroomFragment : Fragment() {
    private lateinit var viewBinding: FragmentTalkroomBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentTalkroomBinding.inflate(layoutInflater)

        val itemList = ArrayList<BoardItem>()
        itemList.apply {
            add(BoardItem("11:11", "안녕하세요", "별이엄마"))
            add(BoardItem("11:11", "안녕하세요", "별이엄마"))
            add(BoardItem("11:11", "안녕하세요", "별이엄마"))
            add(BoardItem("11:11", "안녕하세요", "별이엄마"))

        }
        viewBinding.rvBoard.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        viewBinding.rvBoard.adapter = CommunityBoardAdapter(itemList)
        return viewBinding.root
    }
}