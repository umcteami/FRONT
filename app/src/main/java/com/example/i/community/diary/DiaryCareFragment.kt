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
import com.example.i.community.diary.model.DiaryDInterface
import com.example.i.community.diary.model.DiaryDResponse
import com.example.i.community.diary.model.DiaryDService
import com.example.i.community.talk.post.CommunityPostActivity
import com.example.i.databinding.FragmentDiaryCareBinding
import com.example.i.home.HasImage

class DiaryCareFragment : Fragment(),DiaryDInterface {

    private lateinit var viewBinding : FragmentDiaryCareBinding
    val itemList: ArrayList<DiaryRoomxItem> = arrayListOf()
    var hasImage: HasImage = HasImage.TRUE
    val adapter = DiaryBoardRoomxAdapter(itemList)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewBinding = FragmentDiaryCareBinding.inflate(layoutInflater)

        DiaryDService(this).tryGetDiaryD(1)

        adapter!!.itemClick = object : DiaryBoardRoomxAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val intent = Intent(requireActivity(), CommunityPostActivity::class.java)
                startActivity(intent)
            }
        }

        return viewBinding.root
    }
    override fun onGetDiaryDSuccess(response: DiaryDResponse) {
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
                            response.result[i].title,
                            response.result[i].memNick,
                            response.result[i].memProfile,
                            response.result[i].createAt,
                            response.result[i].hit.toString(),
                            response.result[i].content,
                            response.result[i].img,
                            response.result[i].likeCnt.toString(),
                            response.result[i].commentCnt.toString()

                        )
                    )
                }
            }
        }
        viewBinding.rvDiary.layoutManager = LinearLayoutManager(requireActivity())
        viewBinding.rvDiary.adapter = adapter

        // Result message
        Toast.makeText(activity, response.message, Toast.LENGTH_SHORT).show()
    }


    override fun onGetDiaryDFailure(message: String) {
        Log.d("error", "간호 일기 오류: $message")

    }
}
