package com.example.i.community

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.i.databinding.SearchListLayoutBinding

class ReviewSearchAdapter(val itemList : ArrayList<ReviewSearchItem>) :
RecyclerView.Adapter<ReviewSearchAdapter.BoardViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        val viewBinding =
            SearchListLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BoardViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ReviewSearchAdapter.BoardViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.count()
    }

    inner class BoardViewHolder(private val viewBinding: SearchListLayoutBinding):
            RecyclerView.ViewHolder(viewBinding.root){
                fun bind(item : ReviewSearchItem){
                    viewBinding.tvTitle.text = item.title
                    viewBinding.tvWriter.text = item.writer
                    viewBinding.tvView.text = item.view
                    viewBinding.tvDate.text = item.date
                    viewBinding.tvHeart.text = item.heart
                    viewBinding.tvComment.text = item.comment
                }
            }
}