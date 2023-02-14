package com.example.i.community.diary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.i.databinding.DiaryListImgxLayout2Binding
import com.example.i.databinding.DiaryListImgxLayoutBinding
import com.example.i.databinding.DiaryListLayout2Binding
import com.example.i.databinding.DiaryListLayoutBinding
import com.example.i.home.Const
import com.example.i.home.HasImage

class DiaryBoardRoomxAdapter (val itemList : ArrayList<DiaryRoomxItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

   var itemClick : DiaryBoardRoomxAdapter.ItemClick? = null

    inner class BoardWIthImgViewHolder(val viewBinding : DiaryListLayout2Binding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(item: DiaryRoomxItem) {
            viewBinding.tvWriter.text = item.writer
            Glide.with(viewBinding.ivProfileImage)
                .load(item.memImg)
                .into(viewBinding.ivProfileImage)
            viewBinding.tvTitle.text = item.title
            viewBinding.tvWriteTime.text = item.date
            viewBinding.tvContent.text = item.content
            Glide.with(viewBinding.ivImage1)
                .load(item.Img)
                .into(viewBinding.ivImage1)
            viewBinding.tvView.text = item.view
            viewBinding.tvHeart.text = item.heart
            viewBinding.tvComment.text = item.comment
//            itemView.setOnClickListener {
//            }
        }
    }

    inner class BoardWithoutImgViewHolder(val viewBinding2 : DiaryListImgxLayout2Binding) :
        RecyclerView.ViewHolder(viewBinding2.root) {
        fun bind(item: DiaryRoomxItem) {
            viewBinding2.tvWriter.text = item.writer
            Glide.with(viewBinding2.ivProfileImage)
                .load(item.memImg)
                .into(viewBinding2.ivProfileImage)
            viewBinding2.tvTitle.text = item.title
            viewBinding2.tvWriteTime.text = item.date
            viewBinding2.tvContent.text = item.content
            viewBinding2.tvView.text = item.view
            viewBinding2.tvHeart.text = item.heart
            viewBinding2.tvComment.text = item.comment
//            itemView.setOnClickListener {
//            }
        }
    }


    override fun getItemViewType(position: Int): Int {
        return if(itemList[position].hasImage == HasImage.TRUE) Const.HASIMAGE else Const.NOIMAGE
    }


    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : RecyclerView.ViewHolder {
        return if (viewType == Const.HASIMAGE) {
            val view =
                DiaryListLayout2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
            BoardWIthImgViewHolder(view)
        } else {
            val view = DiaryListImgxLayout2Binding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            BoardWithoutImgViewHolder(view)
        }
    }


    override fun onBindViewHolder(holder : RecyclerView.ViewHolder, position: Int){
        if(getItemViewType(position) == Const.HASIMAGE){
            (holder as DiaryBoardRoomxAdapter.BoardWIthImgViewHolder).bind(itemList[position])
        }else{
            (holder as DiaryBoardRoomxAdapter.BoardWithoutImgViewHolder).bind(itemList[position])
        }

        if(itemClick != null){
            if(itemList[position].hasImage == HasImage.TRUE){
                (holder as DiaryBoardRoomxAdapter.BoardWIthImgViewHolder).viewBinding!!.rootLayout1.setOnClickListener(View.OnClickListener {
                    itemClick?.onClick(it, position)
                })
            }else{
                (holder as DiaryBoardRoomxAdapter.BoardWithoutImgViewHolder).viewBinding2!!.rootLayout2.setOnClickListener(View.OnClickListener {
                    itemClick?.onClick(it, position)
                })
            }
        }
    }


    override fun getItemCount(): Int {
        return itemList.count()
    }

    interface ItemClick{
        fun onClick(view :View, position : Int)
    }
}