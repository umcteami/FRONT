package com.example.i.market

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.databinding.FragmentSupplementBinding

class SupplementFragment: Fragment() {

    private lateinit var viewBinding:FragmentSupplementBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentSupplementBinding.inflate(layoutInflater)

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mkList: ArrayList<Market> = arrayListOf()
        val customDecoration = CustomDecoration(2f, 2f, Color.GRAY)

        mkList.apply{
            add(Market("무료나눔", "강아지 껌", "7시간 전","조회 12", "2"))
            add(Market("무료나눔", "강아지 껌", "7시간 전","조회 12", "2"))
            add(Market("무료나눔", "강아지 껌", "7시간 전","조회 12", "2"))
            add(Market("무료나눔", "강아지 껌", "7시간 전","조회 12", "2"))
            add(Market("무료나눔", "강아지 껌", "7시간 전","조회 12", "2"))
            add(Market("무료나눔", "강아지 껌", "7시간 전","조회 12", "2"))
            add(Market("무료나눔", "강아지 껌", "7시간 전","조회 12", "2"))
            add(Market("무료나눔", "강아지 껌", "7시간 전","조회 12", "2"))
        }

        viewBinding.rvSupplement.layoutManager = LinearLayoutManager(context)
        viewBinding.rvSupplement.adapter = MarketRVAdapter(mkList)
        viewBinding.rvSupplement.addItemDecoration(customDecoration)
    }
}