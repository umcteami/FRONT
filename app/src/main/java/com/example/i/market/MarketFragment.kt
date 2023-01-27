package com.example.i.market

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.i.databinding.FragmentMarketBinding
import com.google.android.material.tabs.TabLayoutMediator

class MarketFragment : Fragment() {
    private lateinit var viewBinding : FragmentMarketBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentMarketBinding.inflate(layoutInflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pageVPAdapter = MarketVPAdapter(requireActivity())
        viewBinding.vpMarket.adapter = pageVPAdapter

        val tabTitleArray = arrayOf(
            "전체",
            "맘마/까까",
            "장난감",
            "영양제/약/간호용품",
            "기타"
        )

        TabLayoutMediator(viewBinding.tapMarket, viewBinding.vpMarket) { tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()
    }
}