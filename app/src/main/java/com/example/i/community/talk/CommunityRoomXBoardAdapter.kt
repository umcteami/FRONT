package com.example.i.community.talk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.i.community.BoardRoomXItem
import com.example.i.databinding.PostListRoomxLayoutBinding
import com.example.i.databinding.PostListRoomxLayoutImgxBinding
import com.example.i.home.Const.HASIMAGE
import com.example.i.home.Const.NOIMAGE
import com.example.i.home.HasImage

class CommunityRoomXBoardAdapter(val itemList: ArrayList<BoardRoomXItem>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    var itemClick : CommunityRoomXBoardAdapter.ItemClick? = null


    inner class RoomXBoardViewHolder(val viewBinding: PostListRoomxLayoutBinding):
        RecyclerView.ViewHolder(viewBinding.root){
        fun bind(item : BoardRoomXItem){
            viewBinding.tvTitle.text = item.title
            Glide.with(viewBinding.ivPostimage)
                .load(item.picture)
                .into(viewBinding.ivPostimage)
            //viewBinding.ivProfileImage.setImageResource(item.picture!!)
            viewBinding.tvWriter.text = item.writer
            Glide.with(viewBinding.ivProfileImage)
                .load(item.Profile)
                .into(viewBinding.ivProfileImage)
            viewBinding.tvWriteTime.text = item.date
            viewBinding.tvView.text = item.view
            viewBinding.tvTitle.text = item.title
            viewBinding.tvHearts.text = item.heart
            viewBinding.tvChat.text = item.comment
        }
    }
    inner class RoomXBoardViewNoImgHolder(val viewBinding2: PostListRoomxLayoutImgxBinding):
        RecyclerView.ViewHolder(viewBinding2.root){
        fun bind(item : BoardRoomXItem){
            viewBinding2.tvTitle.text = item.title
            viewBinding2.tvWriter.text = item.writer
            Glide.with(viewBinding2.ivProfileImage)
                .load(item.Profile)
                .into(viewBinding2.ivProfileImage)
            viewBinding2.tvWriteTime.text = item.date
            viewBinding2.tvView.text = item.view
            viewBinding2.tvTitle.text = item.title
            viewBinding2.tvHearts.text = item.heart
            viewBinding2.tvChat.text = item.comment
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if(itemList[position].hasImage == HasImage.TRUE) HASIMAGE else NOIMAGE
    }


    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : RecyclerView.ViewHolder{
        return if(viewType == HASIMAGE){
            val view = PostListRoomxLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            RoomXBoardViewHolder(view)
        }else{
            val view = PostListRoomxLayoutImgxBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            RoomXBoardViewNoImgHolder(view)
        }
    }

    override fun onBindViewHolder(holder : RecyclerView.ViewHolder, position: Int){
        if(getItemViewType(position) == HASIMAGE){
            (holder as RoomXBoardViewHolder).bind(itemList[position])
        }else{
            (holder as RoomXBoardViewNoImgHolder).bind(itemList[position])
        }

        if(itemClick != null){
            if(itemList[position].hasImage == HasImage.TRUE){
                (holder as CommunityRoomXBoardAdapter.RoomXBoardViewHolder).viewBinding!!.itemRoomx.setOnClickListener(View.OnClickListener {
                    itemClick?.onClick(it, position)
                })
            }else{
                (holder as CommunityRoomXBoardAdapter.RoomXBoardViewNoImgHolder).viewBinding2!!.itemRoomx2.setOnClickListener(View.OnClickListener {
                    itemClick?.onClick(it, position)
                })
            }
        }
    }

    override fun getItemCount(): Int {
        return itemList.count()
    }


    interface ItemClick{
        fun onClick(view : View, position : Int)
    }
}