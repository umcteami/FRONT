package com.example.i.mypage.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.databinding.FragmentReportBinding
import com.example.i.mypage.data.Report
import com.example.i.mypage.data.ReportRVAdapter

class ReportFragment : Fragment() {
    private lateinit var viewBinding: FragmentReportBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentReportBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        backFragment()

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ReportList: ArrayList<Report> = arrayListOf()

        ReportList.apply{
            add(Report("이야기방", "해피엄마님의 게시글이 정상적으로 신고 접수 되었습니다","10분 전"))
            add(Report("채팅", "해피엄마님의 게시글이 정상적으로 신고 접수 되었습니다","10분 전"))
            add(Report("채팅", "해피엄마님의 게시글이 정상적으로 신고 접수 되었습니다","10분 전"))
            add(Report("채팅", "해피엄마님의 게시글이 정상적으로 신고 접수 되었습니다","10분 전"))
            add(Report("채팅", "해피엄마님의 게시글이 정상적으로 신고 접수 되었습니다","10분 전"))
            add(Report("채팅", "해피엄마님의 게시글이 정상적으로 신고 접수 되었습니다","10분 전"))
            add(Report("채팅", "해피엄마님의 게시글이 정상적으로 신고 접수 되었습니다","10분 전"))
        }

        viewBinding.recyclerview.layoutManager = LinearLayoutManager(context)
        viewBinding.recyclerview.adapter = ReportRVAdapter(ReportList)
    }

    //뒤로가기
    private fun backFragment() {
        viewBinding.backBtn.setOnClickListener {
            activity?.let {
                activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.remove(this)
                    ?.commit()
            }
        }
    }
}