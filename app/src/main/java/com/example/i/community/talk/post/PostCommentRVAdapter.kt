package com.example.i.community.talk.post

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.i.databinding.CommentListLayoutBinding

class PostCommentRVAdapter (private val commentList : ArrayList<ItemComment>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    inner class CommentViewHolder(private val viewBinding : CommentListLayoutBinding) :
            RecyclerView.ViewHolder(viewBinding.root){
                fun bind(itemComment : ItemComment){
                    viewBinding.tvWriter.text = itemComment.writer
                    viewBinding.tvCommentWriter.text = itemComment.commentWriter
                    viewBinding.tvContent.text = itemComment.content
                    viewBinding.tvWriteTime.text = itemComment.date
                }
            }

    override fun getItemCount(): Int {
        return commentList.count()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PostCommentRVAdapter.CommentViewHolder).bind(commentList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewBinding = CommentListLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CommentViewHolder(viewBinding)
    }
}