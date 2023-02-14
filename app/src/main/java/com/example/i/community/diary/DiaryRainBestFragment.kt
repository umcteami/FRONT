package com.example.i.community.diary

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.R
import com.example.i.community.talk.models.talkroom.PplTalkroomInterface
import com.example.i.community.talk.models.talkroom.PplTalkroomResponse
import com.example.i.community.talk.models.talkroom.PplTalkroomService
import com.example.i.community.talk.post.CommunityPostActivity
import com.example.i.databinding.FragmentDiaryCareBestBinding
import com.example.i.databinding.FragmentDiaryRainBestBinding
import com.example.i.home.HasImage

class DiaryRainBestFragment : Fragment(), PplTalkroomInterface {
    private lateinit var viewBinding : FragmentDiaryRainBestBinding

    val itemList: ArrayList<DiaryRoomxItem> = arrayListOf()
    val adapter = DiaryBoardRoomxAdapter(itemList)
    var hasImage: HasImage = HasImage.TRUE


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentDiaryRainBestBinding.inflate(layoutInflater)
        PplTalkroomService(this).tryGetPplTalkroom("diary",1,0,2)

        return viewBinding.root
    }

    override fun onGetPplTalkroomSuccess(response: PplTalkroomResponse) {
        if (response.isSuccess) {

            val index: Int = response.result.size - 1

            for (i in 0..index) {

                if (response.result[i].img != null) {
                    hasImage = HasImage.TRUE
                } else {
                    hasImage = HasImage.FALSE
                }
                itemList.apply {
                    add(
                        DiaryRoomxItem(
                            hasImage,
                            response.result[i].title, //제목
                            response.result[i].memNick, //작성자
                            response.result[i].memProfile, //작성자 프로필
                            response.result[i].createAt, //날짜
                            response.result[i].hit.toString(), //조회수
                            "", //임시.......content!!!!!!!!
                            response.result[i].img, //대표 이미지
                            response.result[i].likeCnt.toString(), //좋아요 수
                            response.result[i].commentCnt.toString() //댓글 수
                        )
                    )
                }
            }

            viewBinding.rvDiary.layoutManager =
                LinearLayoutManager(context)
            val adapter = DiaryBoardRoomxAdapter(itemList)
            viewBinding.rvDiary.adapter = adapter

            adapter!!.itemClick = object : DiaryBoardRoomxAdapter.ItemClick {
                override fun onClick(view: View, position: Int) {
                    val intent = Intent(requireActivity(), CommunityPostActivity::class.java)
                    startActivity(intent)
                }
            }
            Toast.makeText(activity, response.message, Toast.LENGTH_SHORT).show()

        }
    }

    override fun onGetPplTalkroomFailure(message: String) {
        Log.d("error","무지개 일기 인기글 오류: $message")
    }
}