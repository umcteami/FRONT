package com.example.i.community.review

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.R
import com.example.i.community.BoardRoomXItem
import com.example.i.community.review.post.ReviewPostActivity
import com.example.i.community.talk.CommunityRoomXBoardAdapter
import com.example.i.community.talk.post.CommunityPostActivity
import com.example.i.databinding.FragmentReviewBinding
import com.example.i.home.HasImage
import com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo

class ReviewFragment : Fragment() {
    private lateinit var viewBinding: FragmentReviewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentReviewBinding.inflate(layoutInflater)
        val itemList = ArrayList<ReviewItem>()
        itemList.apply {
            add(ReviewItem(HasImage.FALSE,"뚱이엄마", "별이장난감이에요", null, "개똥이", "2022.12.21", "3","2","3",null))
        }
        viewBinding.rvBoard.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        val adapter = ReviewRVAdpater(itemList)
        viewBinding.rvBoard.adapter = adapter

        adapter!!.itemClick = object : ReviewRVAdpater.ItemClick{
            override fun onClick(view: View, position: Int) {
                val intent = Intent(requireActivity(), ReviewPostActivity::class.java)
                startActivity(intent)
            }
        }


        return viewBinding.root
    }
}