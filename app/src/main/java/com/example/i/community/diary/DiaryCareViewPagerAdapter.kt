package com.example.i.community.diary

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

private const val NUM_TABS = 2

class DiaryCareViewPagerAdapter (fragmentManger : FragmentManager, lifecycle : Lifecycle) :
FragmentStateAdapter(fragmentManger, lifecycle){
    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> return DiaryCareFragment()
            1 -> return DiaryCareBestFragment()
        }
        return DiaryCareFragment()
    }
}