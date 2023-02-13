package com.example.i.community.diary

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.community.diary.model.diaryT.DiaryInterface
import com.example.i.community.diary.model.diaryT.DiaryResponse
import com.example.i.community.diary.model.diaryT.DiaryService
import com.example.i.community.talk.models.talkroom.TalkroomService
import com.example.i.community.talk.post.CommunityPostActivity
import com.example.i.databinding.FragmentDiaryBinding
import com.example.i.home.HasImage
import com.example.i.home.TtlRVAdapter
import com.example.i.home.Ttls
import com.example.i.home.model.TtlListResponse

class DiaryFragment : Fragment(), DiaryInterface {
    private lateinit var viewBinding: FragmentDiaryBinding

    val itemList: ArrayList<DiaryItem> = arrayListOf()
    val adapter = DiaryBoardAdapter(itemList)
    var hasImage: HasImage = HasImage.TRUE


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentDiaryBinding.inflate(layoutInflater)

        DiaryService(this).tryGetDiaryList()

        return viewBinding.root
    }

    override fun onGetDiaryListSuccess(response: DiaryResponse) {

        // 받아온 정보와 UI 연결
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
                        DiaryItem(
                            hasImage,
                            response.result[i].roomType.toString(), //간호일기 1 ,무지개일기 2
                            response.result[i].title, //제목
                            response.result[i].memNick, //작성자
                            response.result[i].memProfile, //작성자 프로필
                            response.result[i].createAt, //날짜
                            response.result[i].hit.toString(), //조회수
                            //content 추가 되어야 함
                            response.result[i].img, //대표 이미지
                            response.result[i].likeCnt.toString(), //좋아요 수
                            response.result[i].commentCnt.toString() //댓글 수
                        )
                    )
                }
            }

            viewBinding.rvDiary.layoutManager = LinearLayoutManager(requireActivity())
            viewBinding.rvDiary.adapter = adapter

            adapter!!.itemClick = object : DiaryBoardAdapter.ItemClick {
                override fun onClick(view: View, position: Int) {
                    val intent = Intent(requireActivity(), CommunityPostActivity::class.java)
                    //intent.putExtra("memIdx", response.result[position].memIdx)
                    startActivity(intent)
                }
            }

            // Result message
            Toast.makeText(activity, response.message, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onGetDiaryListFailure(message: String) {
        Log.d("error","카테고리 전체글 오류: $message")
    }

}
