package com.example.i.community.talk

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
import com.example.i.community.talk.post.CommunityPostActivity
import com.example.i.databinding.FragmentCommunityTalkBestBinding
import com.example.i.home.HasImage

class CommunityTalkBestFragment : Fragment(), View.OnClickListener{
    private lateinit var viewBinding: FragmentCommunityTalkBestBinding
    private lateinit var main : CommunityTalkActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        saveInstanceState: Bundle?
    ): View?{
        viewBinding = FragmentCommunityTalkBestBinding.inflate(layoutInflater)
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
//        }

        itemList.apply {
            add(
                BoardRoomXItem(
                    HasImage.FALSE,
                    "타이틀타이틀타이틀타이틀",
                    null,
                    "김민지",
                    "2022-23-33-32",
                "2","3","4"
                )
            )
        }

        viewBinding.rvBoard.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val adapter = CommunityRoomXBoardAdapter(itemList)
        viewBinding.rvBoard.adapter = adapter

        adapter!!.itemClick = object : CommunityRoomXBoardAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                val intent = Intent(requireActivity(), CommunityPostActivity::class.java)
                startActivity(intent)
            }
        }
        return viewBinding.root
    }

    override fun onAttach(context : Context){
        super.onAttach(context)
        main = context as CommunityTalkActivity
    }


    override fun onClick(p0: View?) {
        when(view?.id){
            viewBinding.btSort.id ->{
                val dlg = PFilterDialog(main)
                dlg.setOnOkClickedListener { content ->
                    viewBinding.btSort.text = content
                }
                dlg.show()
            }
        }
    }
}