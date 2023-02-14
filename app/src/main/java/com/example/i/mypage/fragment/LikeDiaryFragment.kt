package com.example.i.mypage.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.community.talk.post.CommunityPostActivity
import com.example.i.databinding.FragmentLikeDiaryBinding
import com.example.i.login.memIdx
import com.example.i.mypage.data.*
import com.example.i.mypage.data.like.LikeInterface
import com.example.i.mypage.data.like.LikeResponse
import com.example.i.mypage.data.like.LikeService
import com.example.i.mypage.myName
import com.example.i.mypage.myProfile

class LikeDiaryFragment : Fragment(), LikeInterface {

    private lateinit var viewBinding : FragmentLikeDiaryBinding
    val PostList: ArrayList<MyPost> = arrayListOf()
    val adapter = PostRVAdapter(PostList)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentLikeDiaryBinding.inflate(layoutInflater)

        LikeService(this).tryGetLike(1, 1) // 좋아요한 게시글 API

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter!!.itemClick = object : PostRVAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val intent = Intent(requireActivity(), CommunityPostActivity::class.java)
                startActivity(intent)
            }
        }
    }

    // 좋아요한 게시글 API
    override fun onGetLikeSuccess(response: LikeResponse) {

        // 받아온 정보와 UI 연결
        if(response.isSuccess){
            val index: Int = response.result.size - 1
            viewBinding.postCount.text = "총 ${response.result.size}개의 좋아요한 글이 있어요"

            for (i in 0 ..index) {
                if (response.size != 0) {

                    PostList.apply {
                        add(
                            MyPost(
                                myProfile,
                                response.result[i].feedImg.toString(),
                                response.result[i].roomType.toString(),
                                response.result[i].title.toString(),
                                myName,
                                response.result[i].createAt.toString(),
                                response.result[i].hit.toString(),
                                response.result[i].countLike.toString(),
                                response.result[i].countComment.toString()
                            )
                        )
                    }
                }
            }
            viewBinding.recyclerview.layoutManager = LinearLayoutManager(context)
            viewBinding.recyclerview.adapter = adapter
        }

        // Result message
        Toast.makeText(activity,response.message, Toast.LENGTH_SHORT).show()
    }

    // 서버 연결 실패
    override fun onGetLikeFailure(message: String) {
        Log.d("error", "오류 : $message")
    }
}