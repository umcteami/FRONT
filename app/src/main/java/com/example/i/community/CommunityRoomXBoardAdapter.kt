package com.example.i.community

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.i.databinding.PostListRoomxLayoutBinding

class CommunityRoomXBoardAdapter(val itemList: ArrayList<BoardRoomXItem>):
RecyclerView.Adapter<CommunityRoomXBoardAdapter.RoomXBoardViewHolder>(){
    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : RoomXBoardViewHolder{
        val viewBinding = PostListRoomxLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RoomXBoardViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder : CommunityRoomXBoardAdapter.RoomXBoardViewHolder, position: Int){
        holder.bind(itemList[position])
    }
    override fun getItemCount(): Int {
        return itemList.count()
    }

    inner class RoomXBoardViewHolder(private val viewBinding:PostListRoomxLayoutBinding):
            RecyclerView.ViewHolder(viewBinding.root){
                fun bind(item : BoardRoomXItem){
                    viewBinding.tvWriter.text = item.writer
                    viewBinding.tvWriteTime.text = item.date
                    viewBinding.tvView.text = item.view
                    viewBinding.tvTitle.text = item.title
                    viewBinding.tvHearts.text = item.heart
                    viewBinding.tvChat.text = item.comment
                }
            }
}