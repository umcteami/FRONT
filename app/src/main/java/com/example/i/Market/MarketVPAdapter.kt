package com.example.i.Market

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MarketVPAdapter(market: FragmentActivity): FragmentStateAdapter(market) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> MarketMainFragment()
            1 -> SnackFragment()
            2 -> ToyFragment()
            3 -> SupplementFragment()
            else -> MarketMainFragment()
        }
    }
}