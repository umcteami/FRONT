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
            add(ReviewSearchItem("별이엄마와 거래해봤어요", "누리엄마", "22.12.12", "조회 12", "5", "2"))
            add(ReviewSearchItem("별이엄마와 거래해봤어요", "누리엄마", "22.12.12", "조회 12", "5", "2"))
            add(ReviewSearchItem("별이엄마와 거래해봤어요", "누리엄마", "22.12.12", "조회 12", "5", "2"))
        }
        viewBinding.rvBoard.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        viewBinding.rvBoard.adapter = ReviewSearchAdapter(itemList)
        return viewBinding.root
    }
}