package com.example.i.community.talk

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

private const val NUM_TABS = 2

class CommunityTalkViewPagerAdapter(fragmentManager : FragmentManager, lifecycle: Lifecycle) :
FragmentStateAdapter(fragmentManager, lifecycle)
{
    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> return CommunityTalkFragment()
            1 -> return CommunityTalkBestFragment()
        }
        return CommunityTalkFragment()
    }
}