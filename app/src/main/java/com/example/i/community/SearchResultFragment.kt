package com.example.i.community

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.example.i.R
import com.example.i.databinding.FragmentSearchResultBinding
import com.example.i.databinding.FragmentTalkroomBinding
import com.google.android.material.tabs.TabLayoutMediator

class SearchResultFragment : Fragment() {
    private lateinit var viewBinding: FragmentSearchResultBinding
    private val tabTitleArray = arrayOf(
        "제목+내용",
        "제목",
        "작성자"
    )
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        val viewPager = viewBinding.viewPager
        val tabLayout = viewBinding.tabLayout

        TabLayoutMediator(tabLayout, viewPager){tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentSearchResultBinding.inflate(layoutInflater)
        return viewBinding.root
    }



}