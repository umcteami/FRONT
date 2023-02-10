package com.example.i.community.diary

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.i.databinding.DiaryListLayout2Binding

class DiaryBoardRoomxAdapter (val itemList : ArrayList<DiaryRoomxItem>) :
RecyclerView.Adapter<DiaryBoardRoomxAdapter.BoardViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BoardViewHolder {
        val viewBinding = DiaryListLayout2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  BoardViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: DiaryBoardRoomxAdapter.BoardViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.count()
    }

    inner class BoardViewHolder(private val viewBinding : DiaryListLayout2Binding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(item: DiaryRoomxItem) {
            viewBinding.tvWriter.text = item.writer
            viewBinding.tvWriteTime.text = item.date
            viewBinding.tvView.text = item.view
            viewBinding.tvTitle.text = item.title
            viewBinding.tvHeart.text = item.heart
            viewBinding.tvContent.text = item.content
            viewBinding.tvComment.text = item.comment
            itemView.setOnClickListener {
            }
        }
    }
}