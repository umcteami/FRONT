package com.example.i.mypage.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.databinding.FragmentBlockedBinding
import com.example.i.mypage.data.Blocked
import com.example.i.mypage.data.BlockedRVAdapter

class BlockedFragment : Fragment() {
    private lateinit var viewBinding: FragmentBlockedBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentBlockedBinding.inflate(layoutInflater)

        backFragment() // 뒤로가기

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val BlockList: ArrayList<Blocked> = arrayListOf()

        BlockList.apply{
            add(Blocked("해피엄마", "안녕하세요 해피엄마입니다 ^^"))
            add(Blocked("해피엄마", "안녕하세요 해피엄마입니다 ^^"))
            add(Blocked("해피엄마", "안녕하세요 해피엄마입니다 ^^"))
            add(Blocked("해피엄마", "안녕하세요 해피엄마입니다 ^^"))
            add(Blocked("해피엄마", "안녕하세요 해피엄마입니다 ^^"))
            add(Blocked("해피엄마", "안녕하세요 해피엄마입니다 ^^"))
            add(Blocked("해피엄마", "안녕하세요 해피엄마입니다 ^^"))
        }

        viewBinding.recyclerview.layoutManager = LinearLayoutManager(context)
        viewBinding.recyclerview.adapter = BlockedRVAdapter(BlockList)
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