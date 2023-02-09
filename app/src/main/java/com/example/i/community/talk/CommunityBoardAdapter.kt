package com.example.i.community.talk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.i.community.BoardItem
import com.example.i.community.talk.models.Const
import com.example.i.databinding.PostListLayoutBinding
import com.example.i.databinding.PostListLayoutImgxBinding

class CommunityBoardAdapter(private val itemList: ArrayList<BoardItem>) :
RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == Const.HASIMAGE) {
            val viewBinding =
                PostListLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            BoardViewHolder(viewBinding)
        } else {
            val viewBinding = PostListLayoutImgxBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            BoardViewNoImgHolder(viewBinding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == Const.HASIMAGE) {
            (holder as BoardViewHolder).bind(itemList[position])
        } else {
            (holder as BoardViewNoImgHolder).bind(itemList[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (itemList[position].hasImage) Const.HASIMAGE else Const.NOIMAGE
    }

    override fun getItemCount(): Int {
        return itemList.count()
    }

    inner class BoardViewHolder(private val viewBinding: PostListLayoutBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(item: BoardItem) {
            viewBinding.tvRoominfo.text = item.room
            viewBinding.ivProfileImage.setImageResource(item.picture!!)
            viewBinding.ivPostimage.setImageResource(item.picture!!)
            viewBinding.tvWriter.text = item.writer
            viewBinding.tvWriteTime.text = item.date
            viewBinding.tvView.text = item.view
            viewBinding.tvTitle.text = item.title
            viewBinding.tvHearts.text = item.heart
            viewBinding.tvChat.text = item.comment
        }
    }

    inner class BoardViewNoImgHolder(private val viewBinding: PostListLayoutImgxBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(item: BoardItem) {
            viewBinding.tvRoominfo.text = item.room
            viewBinding.ivProfileImage.setImageResource(item.picture!!)
            viewBinding.tvWriter.text = item.writer
            viewBinding.tvWriteTime.text = item.date
            viewBinding.tvView.text = item.view
            viewBinding.tvTitle.text = item.title
            viewBinding.tvHearts.text = item.heart
            viewBinding.tvChat.text = item.comment
        }
    }
}