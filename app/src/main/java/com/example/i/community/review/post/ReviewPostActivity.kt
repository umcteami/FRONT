package com.example.i.community.review.post

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.R
import com.example.i.community.talk.post.ItemComment
import com.example.i.community.talk.post.PostCommentRVAdapter
import com.example.i.databinding.ActivityReviewPostBinding

class ReviewPostActivity : AppCompatActivity() {
    private lateinit var viewBinding : ActivityReviewPostBinding
    private var heartClick : Boolean = false
    private var cntHeart : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityReviewPostBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btnPostHeart.setOnClickListener{
            if(!heartClick){
                heartClick = true
                viewBinding.ivHeart.setImageResource(R.drawable.ic_post_heart_press)
                cntHeart = viewBinding.tvHeartCnt.text.toString().toInt() + 1
                viewBinding.tvHeartCnt.text = cntHeart.toString()
            }else{
                heartClick = false
                viewBinding.ivHeart.setImageResource(R.drawable.ic_post_heart_normal)
                cntHeart = viewBinding.tvHeartCnt.text.toString().toInt() - 1
                viewBinding.tvHeartCnt.text = cntHeart.toString()
            }
        }
        val commentList : ArrayList<ItemComment> = arrayListOf()
        commentList.apply{
            add(ItemComment("누구엄마","2023.02.10 01:47",null,"살려주시라요"))
            add(ItemComment("누구엄마","2023.02.10 01:47","나야나","살려주시라요"))
            add(ItemComment("누구엄마","2023.02.10 01:47","나야나","살려주시라요"))
            add(ItemComment("누구엄마","2023.02.10 01:47","나야나","살려주시라요"))
            add(ItemComment("누구엄마","2023.02.10 01:47",null,"살려주시라요"))
        }
        viewBinding.rvComment.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        viewBinding.rvComment.adapter = PostCommentRVAdapter(commentList)
    }
}