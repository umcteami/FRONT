package com.example.i.mypage.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.i.databinding.ItemMypostBinding

class PostRVAdapter(private val PostList: ArrayList<MyPost>): RecyclerView.Adapter<PostRVAdapter.ViewHolder>() {

    var itemClick: ItemClick? = null

    inner class ViewHolder(val viewBinding: ItemMypostBinding): RecyclerView.ViewHolder(viewBinding.root) {
        fun bind (MyPost: MyPost) {
            Glide.with(viewBinding.myPostProfile)
                .load(MyPost.profile)
                .into(viewBinding.myPostProfile)

            Glide.with(viewBinding.myPostImg)
                .load(MyPost.img)
                .into(viewBinding.myPostImg)
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
        holder.bind(PostList[position])

        if (itemClick != null) {
            holder.viewBinding!!.itemMypost.setOnClickListener(View.OnClickListener {
                itemClick?.onClick(it, position)
            })
        }
    }

    override fun getItemCount(): Int = PostList.size

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }
}