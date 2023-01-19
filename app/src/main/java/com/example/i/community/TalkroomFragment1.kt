package com.example.i.community

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.databinding.FragmentTalkroomBinding
class TalkroomFragment1 : Fragment() {
    private lateinit var viewBinding : FragmentTalkroomBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentTalkroomBinding.inflate(layoutInflater)

        val itemList = ArrayList<BoardItem>()
        itemList.apply{
            add(BoardItem("11:11","안녕하세요","별이엄마",2,"12","2","자유방"))
            add(BoardItem("12:11","안녕하세요","별이엄마",2,"12","2","자유방"))
            add(BoardItem("11:11","안녕하세요","별이엄마",2,"12","2","자유방"))
            add(BoardItem("11:11","안녕하세요","별이엄마",2,"12","2","자유방"))
        }
        viewBinding.rvBoard.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        viewBinding.rvBoard.adapter=CommunityBoardAdapter(itemList)
        return viewBinding.root
    }
}