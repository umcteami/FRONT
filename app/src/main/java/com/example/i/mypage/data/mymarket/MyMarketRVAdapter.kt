package com.example.i.mypage.data.mymarket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.i.databinding.ItemMarketBinding

class MyMarketRVAdapter(private val mkpList: ArrayList<MyMarket>): RecyclerView.Adapter<MyMarketRVAdapter.ViewHolder>() {

    var itemClick: ItemClick? = null

    inner class ViewHolder(val viewBinding: ItemMarketBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(market : MyMarket) {

            Glide.with(viewBinding.ivMk)
                .load(market.image)
                .into(viewBinding.ivMk)

            viewBinding.tvMkTitle.text = market.title
            viewBinding.tvMkContent.text = market.content
            viewBinding.tvMkLike.text = market.view
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding =
            ItemMarketBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mkpList[position])

        if (itemClick != null) {
            holder.viewBinding!!.itemMarket.setOnClickListener(View.OnClickListener {
                itemClick?.onClick(it, position)
            })
        }
    }

    override fun getItemCount(): Int = mkpList.size

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }
}
