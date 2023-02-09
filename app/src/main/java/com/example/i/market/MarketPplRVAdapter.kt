package com.example.i.market

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.i.databinding.ItemMarket3Binding

class MarketPplRVAdapter(private val mkpList: ArrayList<MarketP>): RecyclerView.Adapter<MarketPplRVAdapter.ViewHolder>() {

    inner class ViewHolder(private val viewBinding: ItemMarket3Binding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(mp: MarketP) {
            viewBinding.ivMk.setImageResource(mp.image)
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
    }

    override fun getItemCount(): Int = mkpList.size
}
