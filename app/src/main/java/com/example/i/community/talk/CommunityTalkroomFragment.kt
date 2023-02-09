package com.example.i.community.talk

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.community.BoardItem
import com.example.i.community.talk.post.CommunityPostActivity
import com.example.i.databinding.FragmentTalkroomBinding

class CommunityTalkroomFragment : Fragment() {
    private lateinit var viewBinding: FragmentTalkroomBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentTalkroomBinding.inflate(layoutInflater)

        val itemList = ArrayList<BoardItem>()
        val adapter = CommunityBoardAdapter(itemList)

        itemList.apply {
            add(
                BoardItem(
                    "22.12.28",
                    "별이엄마",
                    "다니고 계신 병원 정보 좀 (서울/경기도)",
                    "정보방",
                    "12",
                    "2",
                    "3"
                )
            )
            add(
                BoardItem(
                    "22.12.28",
                    "별이엄마",
                    "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)",
                    "정보방",
                    "12",
                    "2",
                    "3"
                )
            )
            add(
                BoardItem(
                    "22.12.28",
                    "별이엄마",
                    "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)",
                    "정보방",
                    "12",
                    "2",
                    "3"
                )
            )
            add(
                BoardItem(
                    "22.12.28",
                    "별이엄마",
                    "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)",
                    "정보방",
                    "12",
                    "2",
                    "3"
                )
            )
            add(
                BoardItem(
                    "22.12.28",
                    "별이엄마",
                    "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)",
                    "정보방",
                    "12",
                    "2",
                    "3"
                )
            )
            add(
                BoardItem(
                    "22.12.28",
                    "별이엄마",
                    "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)",
                    "정보방",
                    "12",
                    "2",
                    "3"
                )
            )
        }


        viewBinding.rvBoard.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        viewBinding.rvBoard.adapter = adapter

        adapter!!.itemClick = object : CommunityBoardAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                val intent = Intent(requireActivity(), CommunityPostActivity::class.java)
                startActivity(intent)
            }
        }

        return viewBinding.root

    }
}