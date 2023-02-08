package com.example.i.market

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MarketVPAdapter(marketMain: FragmentActivity): FragmentStateAdapter(marketMain) {
    val fragments: List<Fragment>
    init{
        fragments = listOf(Ppl1Fragment(), Ppl2Fragment(), Ppl3Fragment())
    }

    override fun getItemCount(): Int = fragments.size

    // 매개변수에 들어가는 인덱스에 해당하는 fragment 출력
    override fun createFragment(position: Int): Fragment = fragments[position]
}