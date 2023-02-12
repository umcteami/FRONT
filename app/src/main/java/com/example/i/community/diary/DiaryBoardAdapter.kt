package com.example.i.community.diary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.i.databinding.DiaryListLayoutBinding

class DiaryBoardAdapter (val itemList : ArrayList<DiaryItem>) :
        RecyclerView.Adapter<DiaryBoardAdapter.BoardViewHolder>(){

    var itemClick : DiaryBoardAdapter.ItemClick? = null
    override fun onCreateViewHolder(parent : ViewGroup, viewType: Int): BoardViewHolder {
        val viewBinding =
            DiaryListLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BoardViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: DiaryBoardAdapter.BoardViewHolder, position: Int) {
        holder.bind(itemList[position])
        if(itemClick != null){
            holder.viewBinding!!.rootLayout.setOnClickListener(View.OnClickListener {
                itemClick?.onClick(it, position)
            })
        }
    }

    override fun getItemCount(): Int {
        return itemList.count()
    }

    inner class BoardViewHolder(val viewBinding: DiaryListLayoutBinding) :
        RecyclerView.ViewHolder(viewBinding.root){
        fun bind(item : DiaryItem){
            viewBinding.tvDiaryInfo.text = item.diary
            viewBinding.tvWriter.text = item.writer
            viewBinding.tvWriteTime.text = item.date
            viewBinding.tvView.text = item.view
            viewBinding.tvTitle.text = item.title
            viewBinding.tvHeart.text = item.heart
            viewBinding.tvContent.text = item.content
            viewBinding.tvComment.text = item.comment
            itemView.setOnClickListener{
            }
        }
    }
    interface ItemClick{
        fun onClick(view : View, position : Int)
    }
}