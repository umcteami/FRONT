package com.example.i.community.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Registry.NoImageHeaderParserException
import com.example.i.community.search.Const.HASIMAGE
import com.example.i.community.search.Const.NOIMAGE
import com.example.i.databinding.SearchListLayoutBinding
import com.example.i.databinding.SearchListLayoutNoimgBinding
import com.example.i.home.HasImage
import com.example.i.home.PplRVAdapter

class ReviewSearchAdapter(val itemList : ArrayList<ReviewSearchItem>) :
RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var itemClick : ReviewSearchAdapter.ItemClick? = null

    override fun getItemViewType(position: Int): Int {
        return if(itemList[position].hasImage == HasImage.TRUE) HASIMAGE else NOIMAGE
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if(viewType == HASIMAGE){
            val view = SearchListLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            BoardViewHolder(view)
        } else{
            val view = SearchListLayoutNoimgBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            BoardViewNoImgHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(getItemViewType(position) == HASIMAGE){
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
                fun bind(item : ReviewSearchItem){
                    viewBinding.tvTitle.text = item.title
                    viewBinding.tvWriter.text = item.writer
                    viewBinding.tvView.text = item.view
                    viewBinding.tvDate.text = item.date
                    viewBinding.tvHeart.text = item.heart
                    viewBinding.tvComment.text = item.comment
                    Glide.with(viewBinding.ivThumbnail)
                        .load(item.picture)
                        .into(viewBinding.ivThumbnail)
                }
            }

    inner class BoardViewNoImgHolder(val viewBinding : SearchListLayoutNoimgBinding):
            RecyclerView.ViewHolder(viewBinding.root){
                fun bind(item : ReviewSearchItem){
                    viewBinding.tvTitle.text = item.title
                    viewBinding.tvWriter.text = item.writer
                    viewBinding.tvView.text = item.view
                    viewBinding.tvDate.text = item.date
                    viewBinding.tvHeart.text = item.heart
                    viewBinding.tvComment.text = item.comment
                }
            }
}

object Const{
    const val HASIMAGE = 0
    const val NOIMAGE = 1
}