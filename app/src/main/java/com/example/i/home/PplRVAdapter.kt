package com.example.i.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.i.databinding.ListItemPplBinding


class PplRVAdapter (private val pplList: ArrayList<Ppls>): RecyclerView.Adapter<PplRVAdapter.DataViewHolder>() {

    inner class DataViewHolder(private val viewBinding: ListItemPplBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(ppls: Ppls) {
            viewBinding.pplTitle.text = ppls.title
//            viewBinding.pplPicture.setImageDrawable
            viewBinding.pplWriter.text = ppls.writer
            viewBinding.pplDate.text = ppls.date
            viewBinding.pplView.text = ppls.view
            viewBinding.pplCommentNum.text = ppls.comment
            viewBinding.pplHaertNum.text = ppls.heart
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PplRVAdapter.DataViewHolder {
        val viewBinding = ListItemPplBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DataViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: PplRVAdapter.DataViewHolder, position: Int) {
       holder.bind(pplList[position])
    }

    override fun getItemCount(): Int = pplList.size
}