package com.example.i.community

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.R
import com.example.i.databinding.FragmentCommunityTalkBinding
import com.example.i.databinding.FragmentTalkroomBinding

class CommunityTalkFragment : Fragment() {
    private lateinit var viewBinding: FragmentCommunityTalkBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentCommunityTalkBinding.inflate(layoutInflater)

        val itemList = ArrayList<BoardRoomXItem>()
        itemList.apply {
            add(BoardRoomXItem("22.12.28", "별이엄마", "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)","12","2","3"))
            add(BoardRoomXItem("22.12.28", "별이엄마", "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)","12","2","3"))
            add(BoardRoomXItem("22.12.28", "별이엄마", "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)","12","2","3"))
            add(BoardRoomXItem("22.12.28", "별이엄마", "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)","12","2","3"))
            add(BoardRoomXItem("22.12.28", "별이엄마", "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)","12","2","3"))
            add(BoardRoomXItem("22.12.28", "별이엄마", "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)","12","2","3"))
            add(BoardRoomXItem("22.12.28", "별이엄마", "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)","12","2","3"))
        }
        viewBinding.rvBoard.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        viewBinding.rvBoard.adapter = CommunityRoomXBoardAdapter(itemList)
        return viewBinding.root
    }
}