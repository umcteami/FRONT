package com.example.i.mypage.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.databinding.FragmentBlockedBinding
import com.example.i.mypage.data.*

class BlockedFragment : Fragment(), BlockInterface {
    private lateinit var viewBinding: FragmentBlockedBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentBlockedBinding.inflate(layoutInflater)

        BlockService(this).tryGetBlock() // 차단한 사용자 API
        backFragment() // 뒤로가기

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    // 차단한 사용자 API
    override fun onGetBlockSuccess(response: BlockResponse) {
        // 받아온 정보와 UI 연결
        if(response.isSuccess){
            val BlockList: ArrayList<Blocked> = arrayListOf()
            BlockList.apply{
                add(Blocked(response.result[2].toString(), response.result[3].toString()))
            }
            viewBinding.recyclerview.layoutManager = LinearLayoutManager(context)
            viewBinding.recyclerview.adapter = BlockedRVAdapter(BlockList)
        }

        // Result message
        Toast.makeText(activity,response.message, Toast.LENGTH_SHORT).show()
    }

    // 서버 연결 실패
    override fun onGetBlockFailure(message: String) {
        Log.d("error", "오류 : $message")
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