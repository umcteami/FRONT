package com.example.i.community.review

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.R
import com.example.i.community.BoardItem
import com.example.i.community.BoardRoomXItem
import com.example.i.community.review.models.ReviewListInterface
import com.example.i.community.review.models.ReviewListResponse
import com.example.i.community.review.models.ReviewListService
import com.example.i.community.review.post.ReviewPostActivity
import com.example.i.community.talk.CommunityBoardAdapter
import com.example.i.community.talk.CommunityRoomXBoardAdapter
import com.example.i.community.talk.post.CommunityPostActivity
import com.example.i.databinding.FragmentReviewBinding
import com.example.i.home.HasImage
import com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo

class ReviewFragment : Fragment(), ReviewListInterface {
    private lateinit var viewBinding: FragmentReviewBinding

    val itemList: ArrayList<ReviewItem> = arrayListOf()
    var hasImage: HasImage = HasImage.TRUE
    val adapter = ReviewRVAdpater(itemList)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentReviewBinding.inflate(layoutInflater)

        ReviewListService(this).tryGetReviewList()


        return viewBinding.root
    }

    override fun onGetReviewListSuccess(response: ReviewListResponse) {
        val index: Int = response.result.size - 1

        for (i in 0..index) {

            if (response.result[i].img != null) {
                hasImage = HasImage.TRUE
            } else {
                hasImage = HasImage.FALSE
            }
            itemList.apply {
                add(
                    ReviewItem(
                        hasImage, //이미지 있는지 여부
                        response.result[i].sellerNick, //거래자 이름
                        response.result[i].goods, //물건
                        response.result[i].profile.toString(), //작성자 프로필
                        response.result[i].memNick, //작성자(산 사람)
                        response.result[i].createAt, //작성일자 및 시간
                        response.result[i].hit.toString(), //조회수
                        response.result[i].likeCnt.toString(), //하트수
                        response.result[i].commentCnt.toString(),//댓글수
                        response.result[i].img//댓글수

                    )
                )
            }
        }
        viewBinding.rvBoard.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        viewBinding.rvBoard.adapter = adapter

        adapter!!.itemClick = object : ReviewRVAdpater.ItemClick{
            override fun onClick(view: View, position: Int) {
                val intent = Intent(requireActivity(), ReviewPostActivity::class.java)
                startActivity(intent)
            }
        }

    }

    override fun onGetReviewListFailure(message: String) {
        Log.d("error", "장터후기 전체 오류: $message")
    }
}