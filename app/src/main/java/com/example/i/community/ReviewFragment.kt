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
        val itemList = ArrayList<BoardRoomXItem>()
        itemList.apply {
            add(BoardRoomXItem("22.12.28", "별이엄마", "춘배귀여워님과 텍스트텍스트 물품을 거래했어요","12","2","3"))
            add(BoardRoomXItem("22.12.28", "별이엄마", "춘배귀여워님과 텍스트텍스트 물품을 거래했어요","12","2","3"))
        }
        viewBinding.rvBoard.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        viewBinding.rvBoard.adapter = CommunityRoomXBoardAdapter(itemList)


        return viewBinding.root
    }
}