package com.example.i.community.talk

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.community.BoardItem
import com.example.i.community.talk.models.talkroom.TalkroomInterface
import com.example.i.community.talk.models.talkroom.TalkroomResponse
import com.example.i.community.talk.models.talkroom.TalkroomService
import com.example.i.community.talk.post.CommunityPostActivity
import com.example.i.databinding.FragmentTalkroomBinding
import com.example.i.home.HasImage

class CommunityTalkroomFragment : Fragment(), TalkroomInterface {
    private lateinit var viewBinding: FragmentTalkroomBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewBinding = FragmentTalkroomBinding.inflate(layoutInflater)

        //리사이클러뷰 데이터 추가
        TalkroomService(this).tryGetTalkroom(5)

        return viewBinding.root

    }

    override fun onGetTalkroomSuccess(response: TalkroomResponse) {
        if (response.isSuccess) {
            val itemList: ArrayList<BoardItem> = arrayListOf()
            val hasImage: HasImage
            val Tadapter = CommunityBoardAdapter(itemList)

            if (response.result[6] != null) {
                hasImage = HasImage.TRUE
            } else {
                hasImage = HasImage.FALSE
            }

            itemList.apply {
                add(
                    BoardItem(
                        hasImage, //이미지 있는지 여부
                        response.result[1].toString(), //세부 카테고리(1.수다방, 2.질문방, 3.정보방)
                        response.result[5].toString(), //제목
                        response.result[6].toString(), //게시글 이미지
                        response.result[4].toString(), //작성자 닉네임
                        response.result[10].toString(), //작성일자 및 시간
                        response.result[7].toString(), //조회수
                        response.result[9].toString(), //하트수
                        response.result[8].toString() //댓글수
                    )
                )
                //
            }

            viewBinding.rvBoard.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            viewBinding.rvBoard.adapter = Tadapter

            Tadapter!!.itemClick = object : CommunityBoardAdapter.ItemClick {
                override fun onClick(view: View, position: Int) {
                    val intent = Intent(requireActivity(), CommunityPostActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }

    override fun onGetTalkroomFailure(message: String) {
        Log.d("error","카테고리 이야기방 전체 오류: $message")
    }
}