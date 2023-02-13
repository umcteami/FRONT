package com.example.i.community

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.community.customdialog.PFilterDialog
import com.example.i.community.diary.DiaryActivity
import com.example.i.community.diary.DiaryBoardAdapter
import com.example.i.community.diary.DiaryItem
import com.example.i.databinding.FragmentDiaryBestBinding

class DiaryBestFragment : Fragment(), View.OnClickListener {
    private lateinit var viewBinding : FragmentDiaryBestBinding
    private lateinit var diary: DiaryActivity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentDiaryBestBinding.inflate(layoutInflater)
        viewBinding.btnSort.setOnClickListener(this)

        val itemList = ArrayList<DiaryItem>()
//        itemList.apply{
//            add(DiaryItem("간호 일기", "해피 간호일기 17일째", "해피엄마","22.12.15","조회 12","오늘은 정기검진 때문에 해피가 병원에 가는 날입니다","12","2"))
//            add(DiaryItem("간호 일기", "해피 간호일기 17일째", "해피엄마","22.12.15","조회 12","오늘은 정기검진 때문에 해피가 병원에 가는 날입니다","12","2"))
//            add(DiaryItem("간호 일기", "해피 간호일기 17일째", "해피엄마","22.12.15","조회 12","오늘은 정기검진 때문에 해피가 병원에 가는 날입니다","12","2"))
//        }
        viewBinding.rvDiary.layoutManager =
            LinearLayoutManager(context)
        viewBinding.rvDiary.adapter = DiaryBoardAdapter(itemList)

        return viewBinding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        diary = context as DiaryActivity
    }

    override fun onClick(view:View?) {
        when(view?.id) {
            viewBinding.btnSort.id -> {
                val dlg = PFilterDialog(diary)
                dlg.setOnOkClickedListener { content ->
                    viewBinding.btnSort.text = content
                }
                dlg.show()
            }
        }
    }
}