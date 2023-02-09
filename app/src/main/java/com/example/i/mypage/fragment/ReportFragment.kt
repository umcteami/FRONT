package com.example.i.mypage.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.databinding.FragmentReportBinding
import com.example.i.mypage.data.*

class ReportFragment : Fragment(), ReportInterface {
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

        ReportService(this).tryGetReport() // 신고한 게시글 API
        backFragment()

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    // 신고한 게시글 API
    override fun onGetReportSuccess(response: ReportResponse) {
        // 받아온 정보와 UI 연결
        if(response.isSuccess){

            val ReportList: ArrayList<Report> = arrayListOf()
            val nick = response.result[2]

            ReportList.apply{
                add(Report(response.result[0].toString(),"{$nick}님의 게시글이 정상적으로 신고 접수 되었습니다", response.result[3].toString()))
            }

            viewBinding.recyclerview.layoutManager = LinearLayoutManager(context)
            viewBinding.recyclerview.adapter = ReportRVAdapter(ReportList)
        }

        // Result message
        Toast.makeText(activity,response.message, Toast.LENGTH_SHORT).show()
    }

    // 서버 연결 실패
    override fun onGetReportFailure(message: String) {
        Log.d("error", "오류 : $message")
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