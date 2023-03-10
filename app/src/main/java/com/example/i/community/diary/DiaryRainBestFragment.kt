package com.example.i.community.diary

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.R
import com.example.i.community.customdialog.PFilterDialog
import com.example.i.community.talk.CommunityTalkroomActivity
import com.example.i.community.talk.post.CommunityPostActivity
import com.example.i.databinding.FragmentDiaryCareBestBinding
import com.example.i.databinding.FragmentDiaryRainBestBinding

class DiaryRainBestFragment : Fragment(), View.OnClickListener {
    private lateinit var viewBinding : FragmentDiaryRainBestBinding
    private lateinit var main : DiaryRainActivity
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentDiaryRainBestBinding.inflate(layoutInflater)
        viewBinding.btSort.setOnClickListener(this)

        val itemList = ArrayList<DiaryRoomxItem>()
//        itemList.apply {
//            add(
//                DiaryRoomxItem(
//                    "해피 간호일기 17일째",
//                    "해피엄마",
//                    "22.12.15",
//                    "조회 12",
//                    "오늘은 정기검진 때문에 해피가 병원에 가는 날입니다",
//                    "12",
//                    "2"
//                )
//            )
//            add(
//                DiaryRoomxItem(
//                    "해피 간호일기 17일째",
//                    "해피엄마",
//                    "22.12.15",
//                    "조회 12",
//                    "오늘은 정기검진 때문에 해피가 병원에 가는 날입니다",
//                    "12",
//                    "2"
//                )
//            )
//            add(
//                DiaryRoomxItem(
//                    "해피 간호일기 17일째",
//                    "해피엄마",
//                    "22.12.15",
//                    "조회 12",
//                    "오늘은 정기검진 때문에 해피가 병원에 가는 날입니다",
//                    "12",
//                    "2"
//                )
//            )
//            add(
//                DiaryRoomxItem(
//                    "해피 간호일기 17일째",
//                    "해피엄마",
//                    "22.12.15",
//                    "조회 12",
//                    "오늘은 정기검진 때문에 해피가 병원에 가는 날입니다",
//                    "12",
//                    "2"
//                )
//            )
//        }
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

    override fun onAttach(context : Context){
        super.onAttach(context)
        main = context as DiaryRainActivity
    }

    override fun onClick(view:View?){
        when(view?.id){
            viewBinding.btSort.id ->{
                val dlg = PFilterDialog(main)
                dlg.setOnOkClickedListener { content ->
                    viewBinding.btSort.text = content
                }
                dlg.show()
            }
        }
    }
}