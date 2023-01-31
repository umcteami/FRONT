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


        val itemList = ArrayList<BoardItem>()
        itemList.apply {
            add(BoardItem("22.12.28", "별이엄마", "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)","","12","2","3"))
            add(BoardItem("22.12.28", "별이엄마", "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)","","12","2","3"))
        }
        viewBinding.rvBoard.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        viewBinding.rvBoard.adapter = CommunityBoardAdapter(itemList)
        return viewBinding.root
    }
}