package com.example.i.mypage.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.databinding.FragmentMyDiaryBinding
import com.example.i.mypage.data.DiaryRVAdapter
import com.example.i.mypage.data.MyPost

class MyDiaryFragment : Fragment() {
    private lateinit var viewBinding: FragmentMyDiaryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentMyDiaryBinding.inflate(layoutInflater)

        backFragment() // 뒤로가기

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val DiaryList: ArrayList<MyPost> = arrayListOf()

        DiaryList.apply{
            add(MyPost("자유방", "다니고 계시는 병원 정보 좀 부탁드려요 (서울/경기도)", "22.12.18","조회 12", "2"))
            add(MyPost("질문방", "해피가 이런 증상을 보이는데 괜찮은 건가요?", "7시간 전","조회 12", "2"))
            add(MyPost("정보방", "소동물 전문 병원 정보 모음 (지역별, 2022.12월 업데이트)", "7시간 전","조회 12", "2"))
            add(MyPost("자유방", "다니고 계시는 병원 정보 좀 부탁드려요 (서울/경기도)", "22.12.18","조회 12", "2"))
            add(MyPost("질문방", "해피가 이런 증상을 보이는데 괜찮은 건가요?", "7시간 전","조회 12", "2"))
            add(MyPost("정보방", "소동물 전문 병원 정보 모음 (지역별, 2022.12월 업데이트)", "7시간 전","조회 12", "2"))
            add(MyPost("자유방", "다니고 계시는 병원 정보 좀 부탁드려요 (서울/경기도)", "22.12.18","조회 12", "2"))
            add(MyPost("질문방", "해피가 이런 증상을 보이는데 괜찮은 건가요?", "7시간 전","조회 12", "2"))
            add(MyPost("정보방", "소동물 전문 병원 정보 모음 (지역별, 2022.12월 업데이트)", "7시간 전","조회 12", "2"))
        }

        viewBinding.recyclerview.layoutManager = LinearLayoutManager(context)
        viewBinding.recyclerview.adapter = DiaryRVAdapter(DiaryList)
    }

    //뒤로가기
    private fun backFragment() {
        viewBinding.backBtn.setOnClickListener {
            activity?.let{
                activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.remove(this)
                    ?.commit()
            }
        }
    }
}