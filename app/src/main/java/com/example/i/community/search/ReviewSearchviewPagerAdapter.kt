package com.example.i.community.search

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

private const val NUM_TABS = 3

class ReviewSearchviewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return ReviewSearchResult1Fragment()
            1 -> return ReviewSearchResult2Fragment()
            2 -> return ReviewSearchResult3Fragment()
        }
        return ReviewSearchResult1Fragment()
    }
}