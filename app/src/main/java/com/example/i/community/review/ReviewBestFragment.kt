package com.example.i.community.review

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.R
import com.example.i.community.BoardRoomXItem
import com.example.i.community.customdialog.PFilterDialog
import com.example.i.community.review.post.ReviewPostActivity
import com.example.i.community.talk.CommunityRoomXBoardAdapter
import com.example.i.community.talk.CommunityTalkroomActivity
import com.example.i.databinding.FragmentReviewBestBinding

class ReviewBestFragment : Fragment(), View.OnClickListener {
    private lateinit var viewBinding : FragmentReviewBestBinding
    private lateinit var review: ReviewActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBinding = FragmentReviewBestBinding.inflate(layoutInflater)
        viewBinding.btSort.setOnClickListener(this)

        val itemList = ArrayList<BoardRoomXItem>()
//        itemList.apply{
//            add(BoardRoomXItem(false,
//                R.drawable.img_1,R.drawable.img_1,"22.12.28", "별이엄마", "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)", "12", "2", "3"))
//            add(BoardRoomXItem(true,
//                R.drawable.img_1,
//                R.drawable.img_1,"22.12.28", "별이엄마", "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)", "12", "2", "3"))
//            add(BoardRoomXItem(false,
//                R.drawable.img_1,R.drawable.img_1,"22.12.28", "별이엄마", "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)", "12", "2", "3"))
//            add(BoardRoomXItem(true,
//                R.drawable.img_1,R.drawable.img_1,"22.12.28", "별이엄마", "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)", "12", "2", "3"))
//            add(BoardRoomXItem(false,
//                R.drawable.img_1,R.drawable.img_1,"22.12.28", "별이엄마", "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)", "12", "2", "3"))
//            add(BoardRoomXItem(true,
//                R.drawable.img_1,
//                R.drawable.img_1,"22.12.28", "별이엄마", "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)", "12", "2", "3"))
//            add(BoardRoomXItem(false,
//                R.drawable.img_1,R.drawable.img_1,"22.12.28", "별이엄마", "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)", "12", "2", "3"))
//            add(BoardRoomXItem(true,
//                R.drawable.img_1,R.drawable.img_1,"22.12.28", "별이엄마", "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)", "12", "2", "3"))
//        }
        viewBinding.rvBoard.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val adapter = CommunityRoomXBoardAdapter(itemList)
        viewBinding.rvBoard.adapter = adapter

        adapter!!.itemClick = object : CommunityRoomXBoardAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                val intent = Intent(requireActivity(), ReviewPostActivity::class.java)
                startActivity(intent)
            }
        }

        return viewBinding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        review = context as ReviewActivity
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            viewBinding.btSort.id -> {
                val dlg = PFilterDialog(review)
                dlg.setOnOkClickedListener { content ->
                    viewBinding.btSort.setText(content)
                }
                dlg.show()
            }
        }
    }
}