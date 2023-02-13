package com.example.i.community.diary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.i.community.talk.CommunityRoomXBoardAdapter
import com.example.i.databinding.DiaryListImgxLayoutBinding
import com.example.i.databinding.DiaryListLayoutBinding
import com.example.i.databinding.PostListRoomxLayoutBinding
import com.example.i.databinding.PostListRoomxLayoutImgxBinding
import com.example.i.home.Const.NOIMAGE
import com.example.i.home.Const.HASIMAGE
import com.example.i.home.HasImage

class DiaryBoardAdapter (val itemList : ArrayList<DiaryItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    var itemClick : DiaryBoardAdapter.ItemClick? = null

    inner class BoardViewWithImgHolder(val viewBinding: DiaryListLayoutBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(item: DiaryItem) {
            viewBinding.tvDiaryInfo.text = item.roomType
            viewBinding.tvWriter.text = item.writer
            Glide.with(viewBinding.ivProfileImage)
                .load(item.memImg)
                .into(viewBinding.ivProfileImage)
            viewBinding.tvTitle.text = item.title
            viewBinding.tvWriteTime.text = item.date
            //viewBinding.tvContent.text = item.content
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
    inner class BoardViewWithoutImgHolder(val viewBinding2: DiaryListImgxLayoutBinding) :
        RecyclerView.ViewHolder(viewBinding2.root) {
        fun bind(item: DiaryItem) {
            viewBinding2.tvDiaryInfo.text = item.roomType
            viewBinding2.tvWriter.text = item.writer
            Glide.with(viewBinding2.ivProfileImage)
                .load(item.memImg)
                .into(viewBinding2.ivProfileImage)
            viewBinding2.tvTitle.text = item.title
            viewBinding2.tvWriteTime.text = item.date
            //viewBinding2.tvContent.text = item.content
            viewBinding2.tvView.text = item.view
            viewBinding2.tvHeart.text = item.heart
            viewBinding2.tvComment.text = item.comment
//            itemView.setOnClickListener {
//            }
        }
    }


    override fun getItemViewType(position: Int): Int {
        return if(itemList[position].hasImage == HasImage.TRUE) HASIMAGE else NOIMAGE
    }

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : RecyclerView.ViewHolder {
        return if (viewType == HASIMAGE) {
            val view =
                DiaryListLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            BoardViewWithImgHolder(view)
        } else {
            val view = DiaryListImgxLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            BoardViewWithoutImgHolder(view)
        }
    }


        override fun onBindViewHolder(holder : RecyclerView.ViewHolder, position: Int){
            if(getItemViewType(position) == HASIMAGE){
                (holder as DiaryBoardAdapter.BoardViewWithImgHolder).bind(itemList[position])
            }else{
                (holder as DiaryBoardAdapter.BoardViewWithoutImgHolder).bind(itemList[position])
            }

            if(itemClick != null){
                if(itemList[position].hasImage == HasImage.TRUE){
                    (holder as DiaryBoardAdapter.BoardViewWithImgHolder).viewBinding!!.rootDiary1.setOnClickListener(View.OnClickListener {
                        itemClick?.onClick(it, position)
                    })
                }else{
                    (holder as DiaryBoardAdapter.BoardViewWithoutImgHolder).viewBinding2!!.rootDiary2.setOnClickListener(View.OnClickListener {
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