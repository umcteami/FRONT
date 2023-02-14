package com.example.i.community.diary

import android.content.Context
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
import com.example.i.community.customdialog.PFilterDialog
import com.example.i.community.talk.CommunityBoardAdapter
import com.example.i.community.talk.models.talkroom.PplTalkroomInterface
import com.example.i.community.talk.models.talkroom.PplTalkroomResponse
import com.example.i.community.talk.models.talkroom.PplTalkroomService
import com.example.i.community.talk.post.CommunityPostActivity
import com.example.i.databinding.FragmentDiaryBestBinding
import com.example.i.home.HasImage

class DiaryBestFragment : Fragment(), View.OnClickListener,PplTalkroomInterface{
    private lateinit var viewBinding : FragmentDiaryBestBinding
    private lateinit var diary: DiaryActivity

    val itemList: ArrayList<DiaryItem> = arrayListOf()
    var hasImage: HasImage = HasImage.TRUE
    val adapter = DiaryBoardAdapter(itemList)


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentDiaryBestBinding.inflate(layoutInflater)
        viewBinding.btSort.setOnClickListener(this)
        PplTalkroomService(this).tryGetPplTalkroom("diary",1,0,0)

        return viewBinding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        diary = context as DiaryActivity
    }

    override fun onClick(p0: View?) {
        when(view?.id) {
            viewBinding.btSort.id -> {
                val dlg = PFilterDialog(diary)
                dlg.setOnOkClickedListener { content ->
                    viewBinding.btSort.setText(content)
                }
                dlg.show()
            }
        }
    }

    override fun onGetPplTalkroomSuccess(response: PplTalkroomResponse) {
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
                        hasImage, //이미지 있는지 여부
                        response.result[i].roomType.toString(), //세부 카테고리(1.수다방, 2.질문방, 3.정보방)
                        response.result[i].title, //제목
                        response.result[i].memNick, //작성자 닉네임
                        response.result[i].memProfile,
                        response.result[i].createAt, //작성일자 및 시간
                        response.result[i].hit.toString(), //조회수
                        response.result[i].title,  //content 임시로 제목 넣어둠
                        response.result[i].img, //게시글 이미지
                        response.result[i].likeCnt.toString(), //하트수
                        response.result[i].commentCnt.toString()//댓글수
                    )
                )
            }
        }
            viewBinding.rvDiary.layoutManager =
                LinearLayoutManager(context)
            val adapter = DiaryBoardAdapter(itemList)
            viewBinding.rvDiary.adapter = adapter

            adapter!!.itemClick = object : DiaryBoardAdapter.ItemClick{
                override fun onClick(view: View, position: Int) {
                    val intent = Intent(requireActivity(), CommunityPostActivity::class.java)
                    startActivity(intent)
                }
            }

        Toast.makeText(activity, response.message, Toast.LENGTH_SHORT).show()
        }

    override fun onGetPplTalkroomFailure(message: String) {
        Log.d("error", "일기장 전체 인기글 오류: $message")
    }
}