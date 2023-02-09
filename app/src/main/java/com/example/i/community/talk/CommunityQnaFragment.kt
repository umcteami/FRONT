package com.example.i.community.talk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.R
import com.example.i.community.BoardRoomXItem
import com.example.i.databinding.FragmentCommunityQnaBinding

class CommunityQnaFragment : Fragment() {
    private lateinit var viewBinding: FragmentCommunityQnaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentCommunityQnaBinding.inflate(layoutInflater)
        val itemList = ArrayList<BoardRoomXItem>()
        itemList.apply {
            add(BoardRoomXItem(false,
                R.drawable.img_1,null,"22.12.28", "별이엄마", "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)", "12", "2", "3"))
            add(BoardRoomXItem(true,
                R.drawable.img_1,
                R.drawable.img_1,"22.12.28", "별이엄마", "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)", "12", "2", "3"))
            add(BoardRoomXItem(false,
                R.drawable.img_1,null,"22.12.28", "별이엄마", "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)", "12", "2", "3"))
            add(BoardRoomXItem(true,
                R.drawable.img_1,R.drawable.img_1,"22.12.28", "별이엄마", "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)", "12", "2", "3"))
            add(BoardRoomXItem(false,
                R.drawable.img_1,null,"22.12.28", "별이엄마", "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)", "12", "2", "3"))
            add(BoardRoomXItem(true,
                R.drawable.img_1,R.drawable.img_1,"22.12.28", "별이엄마", "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)", "12", "2", "3"))
        }

        viewBinding.rvBoard.layoutManager =
            LinearLayoutManager(context)
        viewBinding.rvBoard.adapter = CommunityRoomXBoardAdapter(itemList)
        return viewBinding.root

    }
}