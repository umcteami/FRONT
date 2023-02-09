package com.example.i.community.talk.post

import android.content.ClipData.Item
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.databinding.ActivityCommunityPostBinding

class CommunityPostActivity : AppCompatActivity() {
    private lateinit var viewBinding : ActivityCommunityPostBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityCommunityPostBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val commentList : ArrayList<ItemComment> = arrayListOf()
        commentList.apply{
            add(ItemComment("누구엄마","2023.02.10 01:47","나야나","살려주시라요"))
            add(ItemComment("누구엄마","2023.02.10 01:47","나야나","살려주시라요"))
            add(ItemComment("누구엄마","2023.02.10 01:47","나야나","살려주시라요"))
            add(ItemComment("누구엄마","2023.02.10 01:47","나야나","살려주시라요"))
            add(ItemComment("누구엄마","2023.02.10 01:47",null,"살려주시라요"))
        }
        viewBinding.rvComment.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        viewBinding.rvComment.adapter = PostCommentRVAdapter(commentList)
    }
}