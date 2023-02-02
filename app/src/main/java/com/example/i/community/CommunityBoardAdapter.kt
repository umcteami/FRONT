package com.example.i.community

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.i.R
import com.example.i.databinding.ActivityCommunityQnaBinding
import com.example.i.databinding.PostListLayoutBinding

class CommunityBoardAdapter(val itemList: ArrayList<BoardItem>) :
RecyclerView.Adapter<CommunityBoardAdapter.BoardViewHolder>(){
    override fun onCreateViewHolder(parent : ViewGroup, viewType: Int): BoardViewHolder {
        val viewBinding = PostListLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BoardViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: CommunityBoardAdapter.BoardViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.count()
    }

    inner class BoardViewHolder(private val viewBinding: PostListLayoutBinding) :
        RecyclerView.ViewHolder(viewBinding.root){
        fun bind(item : BoardItem){
            viewBinding.tvRoominfo.text = item.room
            viewBinding.tvWriter.text = item.writer
            viewBinding.tvWriteTime.text = item.date
            viewBinding.tvView.text = item.view
            viewBinding.tvTitle.text = item.title
            viewBinding.tvHearts.text = item.heart
            viewBinding.tvChat.text = item.comment
            viewBinding.rootLayout.setOnClickListener {

            }

        }
    }
}