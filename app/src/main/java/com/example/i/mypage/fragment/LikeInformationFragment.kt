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
import com.example.i.databinding.FragmentLikeInformationBinding
import com.example.i.login.memIdx
import com.example.i.mypage.data.MyPost
import com.example.i.mypage.data.PostRVAdapter
import com.example.i.mypage.data.like.LikeInterface
import com.example.i.mypage.data.like.LikeResponse
import com.example.i.mypage.data.like.LikeService
import com.example.i.mypage.myProfile

class LikeInformationFragment : Fragment(), LikeInterface {

    private lateinit var viewBinding : FragmentLikeInformationBinding
    val PostList: ArrayList<MyPost> = arrayListOf()
    val adapter = PostRVAdapter(PostList)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentLikeInformationBinding.inflate(layoutInflater)
        LikeService(this).tryGetLike(memIdx, 0) // 좋아요한 게시글 API
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

            for (i in 0 ..index) {
                if (response.size != 0) {
                    PostList.apply {
                        add(
                            MyPost(
                                myProfile,
                                response.result[i].feedImg.toString(),
                                response.result[i].roomType.toString(),
                                response.result[i].title.toString(),
                                response.result[i].createAt.toString(),
                                response.result[i].hit.toString(),
                                response.result[i].countLike.toString()
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