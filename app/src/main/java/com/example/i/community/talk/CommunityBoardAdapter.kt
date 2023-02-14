package com.example.i.community.talk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.i.community.BoardItem
import com.example.i.databinding.PostListLayoutBinding
import com.example.i.databinding.PostListLayoutImgxBinding
import com.example.i.home.Const.HASIMAGE
import com.example.i.home.Const.NOIMAGE
import com.example.i.home.HasImage

class CommunityBoardAdapter(val itemList: ArrayList<BoardItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    var itemClick: CommunityBoardAdapter.ItemClick? = null

    inner class BoardWithImgViewHolder(val viewBinding: PostListLayoutBinding) :
        RecyclerView.ViewHolder(viewBinding.root){
        fun bind(item: BoardItem) {
            viewBinding.tvTitle.text = item.title
            Glide.with(viewBinding.ivPostimage)
                .load(item.postImg)
                .into(viewBinding.ivPostimage)
            viewBinding.tvRoominfo.text = item.type
            viewBinding.tvWriter.text = item.writer
            Glide.with(viewBinding.ivProfileImage)
                .load(item.profile)
                .into(viewBinding.ivProfileImage)
            viewBinding.tvWriteTime.text = item.date
            viewBinding.tvView.text = item.view
            viewBinding.tvHearts.text = item.heart
            viewBinding.tvChat.text = item.comment
        }
    }

    inner class BoardWithoutImgViewHolder(val viewBinding2: PostListLayoutImgxBinding) :
        RecyclerView.ViewHolder(viewBinding2.root){
        fun bind(item: BoardItem) {
            viewBinding2.tvTitle.text = item.title
            viewBinding2.tvRoominfo.text = item.type
            viewBinding2.tvWriter.text = item.writer
            Glide.with(viewBinding2.ivProfileImage)
                .load(item.profile)
                .into(viewBinding2.ivProfileImage)
            viewBinding2.tvWriteTime.text = item.date
            viewBinding2.tvView.text = item.view
            viewBinding2.tvHearts.text = item.heart
            viewBinding2.tvChat.text = item.comment
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (itemList[position].hasImage == HasImage.TRUE) HASIMAGE else NOIMAGE
    }

    override fun onCreateViewHolder(parent : ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == HASIMAGE) {
            val view = PostListLayoutBinding.inflate(LayoutInflater.from(parent.context),parent, false)
            BoardWithImgViewHolder(view)
        } else{
            val view = PostListLayoutImgxBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            BoardWithoutImgViewHolder(view)
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == HASIMAGE ) {
            (holder as BoardWithImgViewHolder).bind(itemList[position])
        }else {
            (holder as BoardWithoutImgViewHolder).bind(itemList[position])
        }

        if (itemClick != null) {
            if (itemList[position].hasImage == HasImage.TRUE) {
                (holder as CommunityBoardAdapter.BoardWithImgViewHolder).viewBinding!!.rootLayout.setOnClickListener(
                    View.OnClickListener {
                        itemClick?.onClick(it, position)
                    })
            }  else {
                (holder as CommunityBoardAdapter.BoardWithoutImgViewHolder).viewBinding2!!.rootLayout2.setOnClickListener(
                    View.OnClickListener {
                        itemClick?.onClick(it, position)
                    })
            }
        }
    }

    override fun getItemCount(): Int = itemList.size


    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

}