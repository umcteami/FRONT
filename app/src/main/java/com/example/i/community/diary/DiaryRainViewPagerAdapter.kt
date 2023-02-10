package com.example.i.community.diary

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

private const val NUM_TABS = 2

class DiaryRainViewPagerAdapter (fragmentManger : FragmentManager, lifecycle : Lifecycle) :
    FragmentStateAdapter(fragmentManger, lifecycle){
    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> return DiaryRainFragment()
            1 -> return DiaryRainBestFragment()
        }
        return DiaryCareFragment()
    }
}
