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
import com.example.i.community.BoardItem
import com.example.i.community.talk.models.talkroom.TalkroomInterface
import com.example.i.community.talk.models.talkroom.TalkroomResponse
import com.example.i.community.talk.models.talkroom.TalkroomService
import com.example.i.community.talk.post.CommunityPostActivity
import com.example.i.databinding.FragmentTalkroomBinding
import com.example.i.databinding.PostListLayoutBinding
import com.example.i.home.HasImage

class CommunityTalkroomFragment : Fragment(), TalkroomInterface {
    private lateinit var viewBinding: FragmentTalkroomBinding
    private lateinit var viewBinding2: PostListLayoutBinding
    val itemList: ArrayList<BoardItem> = arrayListOf()
    var hasImage: HasImage = HasImage.TRUE
    val Tadapter = CommunityBoardAdapter(itemList)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        viewBinding = FragmentTalkroomBinding.inflate(layoutInflater)

        //리사이클러뷰 데이터 추가
        TalkroomService(this).tryGetTalkroom()


        return viewBinding.root

    }

    override fun onGetTalkroomSuccess(response: TalkroomResponse) {
        if (response.isSuccess) {

            val index: Int = response.result.size - 1

            for (i in 0..index) {

                if (response.result[i].img != null) {
                    hasImage = HasImage.TRUE
                } else {
                    hasImage = HasImage.FALSE
                }

                var roomType: String = ""

                if(response.result[i].roomType == 1){
                    roomType = "수다방"
                } else if(response.result[i].roomType == 2){
                    roomType="질문방"
                }else{
                  "정보방"
                }

                itemList.apply {
                    add(
                        BoardItem(
                            hasImage, //이미지 있는지 여부
                            response.result[i].roomType.toString(), //세부 카테고리(1.수다방, 2.질문방, 3.정보방)
                            response.result[i].title, //제목
                            response.result[i].img, //게시글 이미지
                            response.result[i].memProfile,
                            response.result[i].memNick, //작성자 닉네임
                            response.result[i].createAt, //작성일자 및 시간
                            response.result[i].hit.toString(), //조회수
                            response.result[i].likeCnt.toString(), //하트수
                            response.result[i].commentCnt.toString()//댓글수
                        )
                    )

                }

            }

            viewBinding.rvBoard.layoutManager =
                LinearLayoutManager(requireActivity())
            viewBinding.rvBoard.adapter = Tadapter

            Tadapter!!.itemClick = object : CommunityBoardAdapter.ItemClick {
                override fun onClick(view: View, position: Int) {
                    val intent = Intent(requireActivity(), CommunityPostActivity::class.java)
                    //글 정보 보내주기: 회원 인덱스, 게시글 인덱스
                    intent.putExtra("storyIdx",response.result[position].feedIdx)
                    intent.putExtra("memIdx",response.result[position].memIdx)
                    startActivity(intent)
                }
            }

            Toast.makeText(activity, response.message, Toast.LENGTH_SHORT).show()
        }
    }


    override fun onGetTalkroomFailure(message: String) {
        Log.d("error", "카테고리 이야기방 전체 오류: $message")
    }
}


