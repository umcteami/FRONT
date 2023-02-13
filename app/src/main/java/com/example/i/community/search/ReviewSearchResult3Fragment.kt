package com.example.i.community.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.databinding.FragmentReviewSearchResult3Binding

class ReviewSearchResult3Fragment : Fragment() {
    private lateinit var viewBinding : FragmentReviewSearchResult3Binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentReviewSearchResult3Binding.inflate(layoutInflater)
        val itemList = ArrayList<ReviewSearchItem>()
        itemList.apply{

        }
        viewBinding.rvBoard.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        viewBinding.rvBoard.adapter = ReviewSearchAdapter(itemList)
        return viewBinding.root
    }
}