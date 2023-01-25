package com.example.i.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.R
import com.example.i.databinding.FragmentBesttalkroomBinding


class BestTalkRoomFragment : Fragment() {
    private lateinit var viewBinding: FragmentBesttalkroomBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentBesttalkroomBinding.inflate(layoutInflater)

        val bests = resources.getStringArray(R.array.best_array)
        //val spinner = viewBinding.spinBestDate


        val itemList = ArrayList<BoardItem>()
        itemList.apply {
            add(BoardItem("11:11", "안녕하세요", "별이엄마"))
            add(BoardItem("12:11", "안녕하세요", "별이엄마"))
            add(BoardItem("11:11", "안녕하세요", "별이엄마"))
            add(BoardItem("11:11", "안녕하세요", "별이엄마"))
        }
        viewBinding.rvBoard.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        viewBinding.rvBoard.adapter = CommunityBoardAdapter(itemList)
        return viewBinding.root
    }
}