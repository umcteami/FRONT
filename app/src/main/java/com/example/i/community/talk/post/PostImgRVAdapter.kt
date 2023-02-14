package com.example.i.community.talk.post

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.i.R
import com.example.i.databinding.CommunityPostItemBinding

class PostImgRVAdapter( private val dataList: ArrayList<Img>,  val onClickDeleteBtn: (data: Img) -> Unit):
    RecyclerView.Adapter<PostImgRVAdapter.DataViewHolder>() {
    inner class DataViewHolder(val binding: CommunityPostItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Img) {
            Glide.with(binding.img)
                .load(data.Image)
                .into(binding.img)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val viewBinding = CommunityPostItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(viewBinding)
    }
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val listposition = dataList[position]
        holder.bind(listposition)
    }
    override fun getItemCount(): Int = dataList.size
}