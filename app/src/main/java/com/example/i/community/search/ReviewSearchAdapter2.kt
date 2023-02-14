package com.example.i.community.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.i.community.review.ReviewItem
import com.example.i.databinding.PostListReviewLayoutBinding
import com.example.i.databinding.SearchListLayoutBinding
import com.example.i.databinding.SearchListLayoutNoimgBinding
import com.example.i.home.HasImage

class ReviewSearchAdapter2(val itemList : ArrayList<ReviewSearchItem2>) :
RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    var itemClick : ReviewSearchAdapter2.ItemClick? = null

    override fun getItemViewType(position: Int): Int {
        return if(itemList[position].hasImage == HasImage.TRUE) Const.HASIMAGE else Const.NOIMAGE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if(viewType == Const.HASIMAGE){
            val view = SearchListLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            BoardViewHolder(view)
        } else{
            val view = SearchListLayoutNoimgBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            BoardViewNoImgHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(getItemViewType(position) == Const.HASIMAGE){
            (holder as BoardViewHolder).bind(itemList[position])
        }else{
            (holder as BoardViewNoImgHolder).bind(itemList[position])
        }

        if(itemClick != null){
            if(itemList[position].hasImage == HasImage.TRUE){
                (holder as ReviewSearchAdapter.BoardViewHolder).viewBinding!!.rootConst.setOnClickListener(
                    View.OnClickListener {
                        itemClick?.onClick(it, position)
                    }
                )
            }else{
                (holder as ReviewSearchAdapter.BoardViewNoImgHolder).viewBinding!!.rootConst.setOnClickListener(
                    View.OnClickListener {
                        itemClick?.onClick(it, position)
                    }
                )
            }
        }
    }

    override fun getItemCount(): Int {
        return itemList.count()
    }

    interface ItemClick{
        fun onClick(view: View, position: Int)
    }

    inner class BoardViewHolder(val viewBinding: SearchListLayoutBinding):
        RecyclerView.ViewHolder(viewBinding.root){
        fun bind(item : ReviewSearchItem2){
            viewBinding.tvTitle.text = "${item.seller}님과 ${item.goods}물품을 거래했어요"
            viewBinding.tvWriter.text = item.writer
            viewBinding.tvView.text = item.view
            viewBinding.tvDate.text = item.date
            viewBinding.tvHeart.text = item.heart
            viewBinding.tvComment.text = item.comment
            Glide.with(viewBinding.ivThumbnail)
                .load(item.img)
                .into(viewBinding.ivThumbnail)
        }
    }

    inner class BoardViewNoImgHolder(val viewBinding : SearchListLayoutNoimgBinding):
        RecyclerView.ViewHolder(viewBinding.root){
        fun bind(item : ReviewSearchItem2){
            viewBinding.tvTitle.text = "${item.seller}님과 ${item.goods}물품을 거래했어요"
            viewBinding.tvWriter.text = item.writer
            viewBinding.tvView.text = item.view
            viewBinding.tvDate.text = item.date
            viewBinding.tvHeart.text = item.heart
            viewBinding.tvComment.text = item.comment
        }
    }
}
