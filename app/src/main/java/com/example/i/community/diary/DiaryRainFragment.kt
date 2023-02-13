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
import com.example.i.community.BoardRoomXItem
import com.example.i.community.diary.model.DiaryDInterface
import com.example.i.community.diary.model.DiaryDResponse
import com.example.i.community.diary.model.DiaryDService
import com.example.i.community.talk.CommunityRoomXBoardAdapter
import com.example.i.community.talk.models.talk.TalkResponse
import com.example.i.community.talk.models.talk.TalkService
import com.example.i.community.talk.post.CommunityPostActivity
import com.example.i.databinding.FragmentDiaryCareBestBinding
import com.example.i.databinding.FragmentDiaryRainBinding
import com.example.i.home.HasImage

class DiaryRainFragment : Fragment(), DiaryDInterface {
    private lateinit var viewBinding: FragmentDiaryRainBinding

    val itemList: ArrayList<DiaryRoomxItem> = arrayListOf()
    var hasImage: HasImage = HasImage.TRUE
    val adapter = DiaryBoardRoomxAdapter(itemList)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentDiaryRainBinding.inflate(layoutInflater)

        DiaryDService(this).tryGetDiaryD(2)
//
//        val itemList = ArrayList<DiaryRoomxItem>()


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
        Log.d("error", "무지개 일기 오류: $message")

    }
}
