package com.example.i.mypage.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.i.databinding.ItemMypostBinding

class DiaryRVAdapter(private val DiaryList: ArrayList<MyPost>): RecyclerView.Adapter<DiaryRVAdapter.ViewHolder>() {

    inner class ViewHolder(private val viewBinding: ItemMypostBinding): RecyclerView.ViewHolder(viewBinding.root) {
        fun bind (MyPost: MyPost) {
            viewBinding.myPostTag.text = MyPost.tag
            viewBinding.myPostContent.text = MyPost.content
            viewBinding.myPostTime.text = MyPost.time
            viewBinding.myPostView.text = MyPost.view
            viewBinding.myPostLike.text = MyPost.num
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding =  ItemMypostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(DiaryList[position])
    }

    override fun getItemCount(): Int = DiaryList.size
}