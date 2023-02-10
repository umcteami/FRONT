package com.example.i.community.diary

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.R
import com.example.i.community.talk.post.CommunityPostActivity
import com.example.i.databinding.FragmentDiaryCareBestBinding
import com.example.i.databinding.FragmentDiaryCareBinding

class DiaryCareBestFragment : Fragment() {
    private lateinit var viewBinding : FragmentDiaryCareBestBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentDiaryCareBestBinding.inflate(layoutInflater)
        val itemList = ArrayList<DiaryRoomxItem>()
        itemList.apply {
            add(
                DiaryRoomxItem(
                    "해피 간호일기 17일째",
                    "해피엄마",
                    "22.12.15",
                    "조회 12",
                    "오늘은 정기검진 때문에 해피가 병원에 가는 날입니다",
                    "12",
                    "2"
                )
            )
            add(
                DiaryRoomxItem(
                    "해피 간호일기 17일째",
                    "해피엄마",
                    "22.12.15",
                    "조회 12",
                    "오늘은 정기검진 때문에 해피가 병원에 가는 날입니다",
                    "12",
                    "2"
                )
            )
            add(
                DiaryRoomxItem(
                    "해피 간호일기 17일째",
                    "해피엄마",
                    "22.12.15",
                    "조회 12",
                    "오늘은 정기검진 때문에 해피가 병원에 가는 날입니다",
                    "12",
                    "2"
                )
            )
            add(
                DiaryRoomxItem(
                    "해피 간호일기 17일째",
                    "해피엄마",
                    "22.12.15",
                    "조회 12",
                    "오늘은 정기검진 때문에 해피가 병원에 가는 날입니다",
                    "12",
                    "2"
                )
            )
        }
        viewBinding.rvDiary.layoutManager =
            LinearLayoutManager(context)
        val adapter = DiaryBoardRoomxAdapter(itemList)
        viewBinding.rvDiary.adapter = adapter

        adapter!!.itemClick = object : DiaryBoardRoomxAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                val intent = Intent(requireActivity(), CommunityPostActivity::class.java)
                startActivity(intent)
            }
        }
        return viewBinding.root
    }
}