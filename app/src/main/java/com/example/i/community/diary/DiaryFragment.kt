package com.example.i.community.diary

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.community.talk.post.CommunityPostActivity
import com.example.i.databinding.FragmentDiaryBinding

class DiaryFragment : Fragment() {
    private lateinit var viewBinding : FragmentDiaryBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        viewBinding = FragmentDiaryBinding.inflate(layoutInflater)

        val itemList = ArrayList<DiaryItem>()
        itemList.apply{
            add(
                DiaryItem(
                    "간호 일기",
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
                DiaryItem(
                    "간호 일기",
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
                DiaryItem(
                    "간호 일기",
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
                DiaryItem(
                    "간호 일기",
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
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val adapter = DiaryBoardAdapter(itemList)
        viewBinding.rvDiary.adapter = adapter

        adapter!!.itemClick = object : DiaryBoardAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                val intent = Intent(requireActivity(), CommunityPostActivity::class.java)
                startActivity(intent)
            }
        }
        return viewBinding.root
    }
}