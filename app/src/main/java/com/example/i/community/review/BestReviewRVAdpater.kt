package com.example.i.community.review


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.i.community.talk.CommunityBoardAdapter
import com.example.i.databinding.*
import com.example.i.home.HasImage
import com.example.i.home.Const.HASIMAGE
import com.example.i.home.Const.NOIMAGE

class BestReviewRVAdpater(private val itemList: ArrayList<BestReviewItem>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var itemClick: BestReviewRVAdpater.ItemClick? = null

    inner class BestReviewWithImgViewHolder(val viewBinding: PostListBestReviewLayoutBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(item: BestReviewItem) {
            viewBinding.tvTitle.text = item.title
            Glide.with(viewBinding.ivProfileImage)
                .load(item.profile)
                .into(viewBinding.ivProfileImage)
            viewBinding.tvWriter.text = item.writer
            viewBinding.tvWriteTime.text = item.date
            viewBinding.tvView.text = item.view
            viewBinding.tvHearts.text = item.heart
            viewBinding.tvCommentCnt.text = item.comment
            Glide.with(viewBinding.ivPostimage)
                .load(item.img)
                .into(viewBinding.ivPostimage)

        }
    }
    inner class BestReviewWithoutImgViewHolder(val viewBinding2: PostListBestReviewImgxLayoutBinding) :
        RecyclerView.ViewHolder(viewBinding2.root) {
        fun bind(item: BestReviewItem) {
            viewBinding2.tvTitle.text = item.title
            Glide.with(viewBinding2.ivProfileImage)
                .load(item.profile)
                .into(viewBinding2.ivProfileImage)
            viewBinding2.tvWriter.text = item.writer
            viewBinding2.tvWriteTime.text = item.date
            viewBinding2.tvView.text = item.view
            viewBinding2.tvHearts.text = item.heart
            viewBinding2.tvCommentCnt.text = item.comment

        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (itemList[position].hasImage == HasImage.TRUE) HASIMAGE else NOIMAGE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == HASIMAGE) {
            val view = PostListBestReviewLayoutBinding.inflate(LayoutInflater.from(parent.context),parent, false)
            BestReviewWithImgViewHolder(view)
        } else {
            val view = PostListBestReviewImgxLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            BestReviewWithoutImgViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == HASIMAGE ) {
            (holder as BestReviewRVAdpater.BestReviewWithImgViewHolder).bind(itemList[position])
        }else {
            (holder as BestReviewRVAdpater.BestReviewWithoutImgViewHolder).bind(itemList[position])
        }

        if (itemClick != null) {
            if (itemList[position].hasImage == HasImage.TRUE) {
                (holder as BestReviewRVAdpater.BestReviewWithImgViewHolder).viewBinding!!.rootLayout1.setOnClickListener(
                    View.OnClickListener {
                        itemClick?.onClick(it, position)
                    })
            }  else {
                (holder as BestReviewRVAdpater.BestReviewWithoutImgViewHolder).viewBinding2!!.rootLayout2.setOnClickListener(
                    View.OnClickListener {
                        itemClick?.onClick(it, position)
                    })
            }
        }
    }

    override fun getItemCount(): Int = itemList.size

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }
}