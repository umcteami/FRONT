package com.example.i.community

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.R
import com.example.i.databinding.FragmentCommunityInfoBestBinding
import com.example.i.databinding.FragmentCommunityInfoBinding

class CommunityInfoBestFragment : Fragment() {
    private lateinit var viewBinding: FragmentCommunityInfoBestBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentCommunityInfoBestBinding.inflate(layoutInflater)
        val itemList = ArrayList<BoardRoomXItem>()
        itemList.apply {
            add(BoardRoomXItem("22.12.28", "별이엄마", "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)","12","2","3"))
            add(BoardRoomXItem("22.12.28", "별이엄마", "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)","12","2","3"))
            add(BoardRoomXItem("22.12.28", "별이엄마", "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)","12","2","3"))
            add(BoardRoomXItem("22.12.28", "별이엄마", "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)","12","2","3"))
            add(BoardRoomXItem("22.12.28", "별이엄마", "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)","12","2","3"))
            add(BoardRoomXItem("22.12.28", "별이엄마", "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)","12","2","3"))
        }

        viewBinding.rvBoard.layoutManager =
            LinearLayoutManager(context)
        viewBinding.rvBoard.adapter = CommunityRoomXBoardAdapter(itemList)
        return viewBinding.root

    }
}