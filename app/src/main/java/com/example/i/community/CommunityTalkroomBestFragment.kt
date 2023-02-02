package com.example.i.community

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.R
import com.example.i.databinding.FragmentCommunityTalkroomBestBinding
import com.example.i.market.MkFilterDialog


class CommunityTalkroomBestFragment : Fragment(), View.OnClickListener {
    private lateinit var viewBinding: FragmentCommunityTalkroomBestBinding
    private lateinit var main : CommunityTalkroomActivity
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentCommunityTalkroomBestBinding.inflate(layoutInflater)

        val itemList = ArrayList<BoardItem>()
        itemList.apply {
            add(BoardItem("22.12.28", "별이엄마", "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)", "수다방", "12", "2", "3"))
            add(BoardItem("22.12.28", "별이엄마", "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)", "수다방", "12", "2", "3"))
        }
        viewBinding.rvBoard.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        viewBinding.rvBoard.adapter = CommunityBoardAdapter(itemList)
        return viewBinding.root
    }

    override fun onClick(view:View?){
        when(view?.id){
            viewBinding.filterLayout.id ->{
                val dlg = MkFilterDialog(main)
                dlg.setOnOkClickedListener { content ->
                    viewBinding.tvViewDate.text = content
                }
                dlg.show()
            }
        }
    }
}