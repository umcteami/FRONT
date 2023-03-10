package com.example.i.mypage.data.want

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.i.databinding.ItemLikeMarketBinding

class LikeMarketRVAdapter(private val LikeList: ArrayList<LikeMarket>): RecyclerView.Adapter<LikeMarketRVAdapter.ViewHolder>() {

    var itemClick: ItemClick? = null

    inner class ViewHolder(val viewBinding: ItemLikeMarketBinding): RecyclerView.ViewHolder(viewBinding.root) {
        fun bind (LikeMarket: LikeMarket) {

            Glide.with(viewBinding.imgLikeMarket)
                .load(LikeMarket.image)
                .into(viewBinding.imgLikeMarket)

            viewBinding.tvTitle.text = LikeMarket.title
            viewBinding.tvContent.text = LikeMarket.content
            viewBinding.tvTime.text = LikeMarket.time
            viewBinding.tvView.text = LikeMarket.view
            viewBinding.tvLike.text = LikeMarket.like

            viewBinding.btLike.isSelected = true

            // 버튼 눌린 상태
            viewBinding.btLike.setOnClickListener {
                viewBinding.btLike.isSelected = viewBinding.btLike.isSelected != true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding =  ItemLikeMarketBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(LikeList[position])

        if (itemClick != null) {

            holder.viewBinding!!.itemLikeMarket.setOnClickListener(View.OnClickListener {
                itemClick?.onClick(it, position)
            })
        }
    }

    override fun getItemCount(): Int = LikeList.size

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }
}