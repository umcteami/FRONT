package com.example.i.community.talk

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

private const val NUM_TABS = 2

class CommunityInfoViewpagerAdapter (fragmentManager : FragmentManager, lifecycle : Lifecycle) :
FragmentStateAdapter(fragmentManager, lifecycle){
    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> return CommunityInfoFragment()
            1 -> return CommunityInfoBestFragment()
        }
        return CommunityInfoFragment()
    }

    override fun getItemCount(): Int {
        return NUM_TABS
    }
}