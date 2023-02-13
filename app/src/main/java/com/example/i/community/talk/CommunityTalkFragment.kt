package com.example.i.community.talk

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.R
import com.example.i.community.BoardRoomXItem
import com.example.i.community.talk.models.talk.TalkInterface
import com.example.i.community.talk.models.talk.TalkResponse
import com.example.i.community.talk.models.talk.TalkService
import com.example.i.community.talk.models.talkroom.TalkroomService
import com.example.i.community.talk.post.CommunityPostActivity
import com.example.i.databinding.FragmentCommunityTalkBinding
import com.example.i.home.HasImage
import com.example.i.home.Ttls

class CommunityTalkFragment : Fragment(), TalkInterface {
    private lateinit var viewBinding: FragmentCommunityTalkBinding
    val itemList: ArrayList<BoardRoomXItem> = arrayListOf()
    var hasImage: HasImage = HasImage.TRUE
    val adapter = CommunityRoomXBoardAdapter(itemList)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentCommunityTalkBinding.inflate(layoutInflater)

        //리사이클러뷰 데이터 추가=
        TalkService(this).tryGetTalk(1)

        adapter!!.itemClick = object : CommunityRoomXBoardAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val intent = Intent(requireActivity(), CommunityPostActivity::class.java)
                startActivity(intent)
            }
        }

//        val itemList = ArrayList<BoardRoomXItem>()
//        itemList.apply {
//            add(BoardRoomXItem(false,
//                R.drawable.img_1,R.drawable.img_1,"22.12.28", "별이엄마", "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)", "12", "2", "3"))
//            add(BoardRoomXItem(true,
//                R.drawable.img_1,R.drawable.img_1,"22.12.28", "별이엄마", "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)", "12", "2", "3"))
//            add(BoardRoomXItem(false,
//                R.drawable.img_1,R.drawable.img_1,"22.12.28", "별이엄마", "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)", "12", "2", "3"))
//            add(BoardRoomXItem(true,
//                R.drawable.img_1,R.drawable.img_1,"22.12.28", "별이엄마", "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)", "12", "2", "3"))
//            add(BoardRoomXItem(false,
//                R.drawable.img_1,R.drawable.img_1,"22.12.28", "별이엄마", "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)", "12", "2", "3"))
//            add(BoardRoomXItem(true,
//                R.drawable.img_1,R.drawable.img_1,"22.12.28", "별이엄마", "다니고 계신 병원 정보 좀 부탁드려요 (서울/경기도)", "12", "2", "3"))
//
//        }
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


    override fun onGetTalkSuccess(response: TalkResponse) {
        if (response.isSuccess) {
            val index: Int = response.result.size - 1

            for (i in 0 ..index) {

                if (response.result[i].img != null) {
                    hasImage = HasImage.TRUE
                } else {
                    hasImage = HasImage.FALSE
                }

                itemList.apply {
                    add(
                        BoardRoomXItem(
                            hasImage,
                            response.result[i].title,
                            response.result[i].img,
                            response.result[i].memNick,
                            response.result[i].createAt,
                            response.result[i].hit.toString(),
                            response.result[i].likeCnt.toString(),
                            response.result[i].commentCnt.toString()
                        )
                    )
                }
            }
        }
        viewBinding.rvBoard.layoutManager = LinearLayoutManager(requireActivity())
        viewBinding.rvBoard.adapter = adapter

        // Result message
        Toast.makeText(activity,response.message, Toast.LENGTH_SHORT).show()
    }

    override fun onGetTalkFailure(message: String)  {
        Log.d("error","수다방 오류: $message")
    }
}
