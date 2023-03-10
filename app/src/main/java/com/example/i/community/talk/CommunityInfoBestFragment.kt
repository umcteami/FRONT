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
import com.example.i.databinding.FragmentCommunityInfoBestBinding

class CommunityInfoBestFragment : Fragment(), View.OnClickListener {
    private lateinit var viewBinding: FragmentCommunityInfoBestBinding
    private lateinit var info: CommunityInfoActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentCommunityInfoBestBinding.inflate(layoutInflater)

        viewBinding.btSort.setOnClickListener(this)

        val itemList = ArrayList<BoardRoomXItem>()
//        itemList.apply {
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
//                R.drawable.img_1,R.drawable.img_1,"22.12.28", "별이엄마", "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)", "12", "2", "3"))
//        }

        viewBinding.rvBoard.layoutManager =
            LinearLayoutManager(context)
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

    override fun onAttach(context: Context) {
        super.onAttach(context)

        info = context as CommunityInfoActivity
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            viewBinding.btSort.id -> {
                val dlg = PFilterDialog(info)
                dlg.setOnOkClickedListener { content ->
                    viewBinding.btSort.setText(content)
                }
                dlg.show()
            }
        }
    }
}