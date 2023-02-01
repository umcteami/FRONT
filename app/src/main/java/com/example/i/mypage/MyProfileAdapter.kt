package com.example.i.mypage

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.i.mypage.fragment.*

class MyProfileAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager,lifecycle) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0-> ProfilePostFragment()
            1-> ProfileCommentFragment()
            2-> ProfileMarketFragment()
            else-> Fragment()
        }
    }
}