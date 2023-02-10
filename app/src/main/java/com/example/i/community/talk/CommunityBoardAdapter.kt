package com.example.i.community.talk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.i.community.BoardItem
import com.example.i.databinding.PostListLayoutBinding
import com.example.i.databinding.PostListLayoutImgxBinding
import com.example.i.home.Const

class CommunityBoardAdapter(val itemList: ArrayList<BoardItem>) :
RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    var itemClick: CommunityBoardAdapter.ItemClick? = null

    override fun onCreateViewHolder(parent : ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if(viewType == Const.HASIMAGE){
            val viewBinding = PostListLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            BoardViewHolder(viewBinding)
        }else{
            val viewBinding = PostListLayoutImgxBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            BoardViewNoImgHolder(viewBinding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(getItemViewType(position) == Const.HASIMAGE){
            (holder as BoardViewHolder).bind(itemList[position])
        }else{
            (holder as BoardViewNoImgHolder).bind(itemList[position])
        }

        if (itemClick != null) {
            if(itemList[position].hasImage == true){
                (holder as CommunityBoardAdapter.BoardViewHolder).viewBinding!!.itemRoomo.setOnClickListener(View.OnClickListener {
                    itemClick?.onClick(it,position)
                })
            }else{
                (holder as CommunityBoardAdapter.BoardViewNoImgHolder).viewBinding!!.itemRoomo2.setOnClickListener(View.OnClickListener {
                    itemClick?.onClick(it, position)
                })
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if(itemList[position].hasImage) Const.HASIMAGE else Const.NOIMAGE
    }

    override fun getItemCount(): Int {
        return itemList.count()
    }

    inner class BoardViewHolder(val viewBinding: PostListLayoutBinding) :
        RecyclerView.ViewHolder(viewBinding.root){
        fun bind(item: BoardItem) {
            viewBinding.ivPostimage.setImageResource(item.picture!!)
            viewBinding.ivProfileImage.setImageResource(item.picture!!)
            viewBinding.tvRoominfo.text = item.room
            viewBinding.tvWriter.text = item.writer
            viewBinding.tvWriteTime.text = item.date
            viewBinding.tvView.text = item.view
            viewBinding.tvTitle.text = item.title
            viewBinding.tvHearts.text = item.heart
            viewBinding.tvChat.text = item.comment
        }
    }

    inner class BoardViewNoImgHolder(val viewBinding: PostListLayoutImgxBinding) :
        RecyclerView.ViewHolder(viewBinding.root){
        fun bind(item: BoardItem) {
            viewBinding.ivProfileImage.setImageResource(item.picture!!)
            viewBinding.tvRoominfo.text = item.room
            viewBinding.tvWriter.text = item.writer
            viewBinding.tvWriteTime.text = item.date
            viewBinding.tvView.text = item.view
            viewBinding.tvTitle.text = item.title
            viewBinding.tvHearts.text = item.heart
            viewBinding.tvChat.text = item.comment
        }
    }
    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

}