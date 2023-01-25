package com.example.i.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.databinding.FragmentReviewBinding

class ReviewFragment : Fragment() {
    private lateinit var viewBinding: FragmentReviewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentReviewBinding.inflate(layoutInflater)
        val itemList = ArrayList<BoardItem>()
        itemList.apply {
            add(BoardItem("12:00", "똘이엄마와 거래한 후기 입니다", "별이엄마", 2, "12", "4", "장터후기"))

        }
        viewBinding.rvBoard.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        viewBinding.rvBoard.adapter = CommunityBoardAdapter(itemList)
        return viewBinding.root
    }
}