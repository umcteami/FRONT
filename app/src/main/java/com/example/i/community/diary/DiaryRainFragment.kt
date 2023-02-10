package com.example.i.community.diary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.R
import com.example.i.databinding.FragmentDiaryCareBestBinding
import com.example.i.databinding.FragmentDiaryRainBinding

class DiaryRainFragment : Fragment() {
    private lateinit var viewBinding : FragmentDiaryRainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentDiaryRainBinding.inflate(layoutInflater)
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
        viewBinding.rvDiary.adapter = DiaryBoardRoomxAdapter(itemList)
        return viewBinding.root
    }
}