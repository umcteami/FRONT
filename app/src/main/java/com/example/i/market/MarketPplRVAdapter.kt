package com.example.i.market

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.i.databinding.ItemMarket3Binding

class MarketPplRVAdapter(private val mkpList: ArrayList<MarketP>): RecyclerView.Adapter<MarketPplRVAdapter.ViewHolder>() {

    var itemClick: ItemClick? = null

    inner class ViewHolder(val viewBinding: ItemMarket3Binding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(mp: MarketP) {
            Glide.with(viewBinding.ivMk)
                .load(mp.image)
                .into(viewBinding.ivMk)
            viewBinding.tvMkTitle.text = mp.title
            viewBinding.tvMkContent.text = mp.content
            viewBinding.tvMkView.text = mp.view
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding =
            ItemMarket3Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mkpList[position])

        if (itemClick != null) {
            holder.viewBinding!!.itemMarket3.setOnClickListener(View.OnClickListener {
                itemClick?.onClick(it, position)
            })
        }
    }

    override fun getItemCount(): Int = mkpList.size

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }
}
