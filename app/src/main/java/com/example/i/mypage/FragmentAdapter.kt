package com.example.i.mypage

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.i.mypage.fragment.LikeDiaryFragment
import com.example.i.mypage.fragment.LikeInformationFragment
import com.example.i.mypage.fragment.LikeStoryFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager,lifecycle) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0-> LikeStoryFragment()
            1-> LikeDiaryFragment()
            2-> LikeInformationFragment()
            else-> Fragment()
        }
    }
}