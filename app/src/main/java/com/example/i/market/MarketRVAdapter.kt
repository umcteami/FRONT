package com.example.i.market

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.i.databinding.ItemMarket2Binding

class MarketRVAdapter(private val mkList: ArrayList<Market>): RecyclerView.Adapter<MarketRVAdapter.ViewHolder>() {

    inner class ViewHolder(private val viewBinding: ItemMarket2Binding): RecyclerView.ViewHolder(viewBinding.root) {
        fun bind (Market: Market) {
            viewBinding.tvTitle.text = Market.title
            viewBinding.tvContent.text = Market.content
            viewBinding.tvView.text = Market.view
            viewBinding.tvTime.text = Market.time
            viewBinding.tvNum.text = Market.num
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding =  ItemMarket2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mkList[position])
    }

    override fun getItemCount(): Int = mkList.size
}