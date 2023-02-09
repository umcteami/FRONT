package com.example.i.community.review

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
            0 -> return ReviewSearchResultFragment()
            1 -> return ReviewSearchResultFragment()
            2 -> return ReviewSearchResultFragment()
        }
        return ReviewSearchResultFragment()
    }
}