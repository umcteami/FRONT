package com.example.i.community.talk.post

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.marginLeft
import androidx.recyclerview.widget.RecyclerView
import com.example.i.databinding.CommentListLayoutBinding

class PostCommentRVAdapter (private val commentList : ArrayList<ItemComment>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    var menuClick : PostCommentRVAdapter.MenuClick? = null
    var replyClick : PostCommentRVAdapter.ReplyClick? = null

    inner class CommentViewHolder(val viewBinding : CommentListLayoutBinding) :
            RecyclerView.ViewHolder(viewBinding.root){
                fun bind(itemComment : ItemComment){
                    viewBinding.tvWriter.text = itemComment.writer
                    viewBinding.tvCommentWriter.text = itemComment.commentWriter
                    viewBinding.tvContent.text = itemComment.content
                    viewBinding.tvWriteTime.text = itemComment.date
                    if(viewBinding.tvCommentWriter == null || itemComment.commentWriter != null || itemComment.writer != itemComment.commentWriter){
                        viewBinding.tvCommentWriter.visibility  = View.GONE
                        viewBinding.root
                    }
//                    else{
//                        val vinding =
//                        val params = viewBinding.view.layoutParams as ViewGroup.MarginLayoutParams
//                        params.leftMargin = dpToPx(16)
//                        viewBinding.view.layoutParams = params
//                    }
                }
            }

    override fun getItemCount(): Int {
        return commentList.count()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PostCommentRVAdapter.CommentViewHolder).bind(commentList[position])

        if(menuClick != null){
            (holder as PostCommentRVAdapter.CommentViewHolder).viewBinding!!.btnPostCommentMenu.setOnClickListener(
                View.OnClickListener {
                    menuClick?.onClick(it, position)
                })
        }

        if(replyClick != null){
            (holder as PostCommentRVAdapter.CommentViewHolder).viewBinding!!.tvWriteReply.setOnClickListener(
                View.OnClickListener {
                    replyClick?.onClick(it, position)
                }
            )

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewBinding = CommentListLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CommentViewHolder(viewBinding)
    }

    interface MenuClick{
        fun onClick(view:View,position :Int)
    }

    interface ReplyClick {
        fun onClick(view: View, position: Int)
    }
    fun dpToPx(dp: Int): Int {
        return (dp * Resources.getSystem().displayMetrics.density + 0.5f).toInt()
    }
}