package com.example.i.community.talk

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.i.community.BoardRoomXItem
import com.example.i.databinding.PostListRoomxLayoutBinding
import com.example.i.databinding.PostListRoomxLayoutImgxBinding

class CommunityRoomXBoardAdapter(val itemList: ArrayList<BoardRoomXItem>):
RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : RecyclerView.ViewHolder{
        return if(viewType == Const.HASIMAGE){
            val viewBinding = PostListRoomxLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            RoomXBoardViewHolder(viewBinding)
        }else{
            val viewBinding = PostListRoomxLayoutImgxBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            RoomXBoardViewNoImgHolder(viewBinding)
        }
    }

    override fun onBindViewHolder(holder : RecyclerView.ViewHolder, position: Int){
        if(getItemViewType(position) == Const.HASIMAGE){
            (holder as CommunityRoomXBoardAdapter.RoomXBoardViewHolder).bind(itemList[position])
        }else{
            (holder as CommunityRoomXBoardAdapter.RoomXBoardViewNoImgHolder).bind(itemList[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if(itemList[position].hasImage) Const.HASIMAGE else Const.NOIMAGE
    }
    override fun getItemCount(): Int {
        return itemList.count()
    }

    inner class RoomXBoardViewHolder(private val viewBinding: PostListRoomxLayoutBinding):
            RecyclerView.ViewHolder(viewBinding.root){
                fun bind(item : BoardRoomXItem){
                    viewBinding.ivPostimage.setImageResource(item.picture!!)
                    viewBinding.ivProfileImage.setImageResource(item.picture!!)
                    viewBinding.tvWriter.text = item.writer
                    viewBinding.tvWriteTime.text = item.date
                    viewBinding.tvView.text = item.view
                    viewBinding.tvTitle.text = item.title
                    viewBinding.tvHearts.text = item.heart
                    viewBinding.tvChat.text = item.comment
                }
            }
    inner class RoomXBoardViewNoImgHolder(private val viewBinding: PostListRoomxLayoutImgxBinding):
        RecyclerView.ViewHolder(viewBinding.root){
        fun bind(item : BoardRoomXItem){
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