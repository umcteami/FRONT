package com.example.i.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.i.databinding.ListItemTtlBinding

class TtlRVAdapter(private val ttlList:ArrayList<Ttls>) : RecyclerView.Adapter<TtlRVAdapter.DataViewHolder>() {

    inner class DataViewHolder(private val viewBinding: ListItemTtlBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(ttls: Ttls) {
            viewBinding.ttlTitle.text = ttls.title
//            viewBinding.ttlPicture.setImageDrawable(ttls.picture)
            viewBinding.ttlWriter.text = ttls.writer
            viewBinding.ttlDate.text = ttls.date
            viewBinding.ttlViewNum.text = ttls.view
            viewBinding.ttlHaertNum.text = ttls.heart
            viewBinding.tlCommentNum.text = ttls.comment

        }
    }

//    override fun getViewTypes(position: Int) =
//        if (mydata[position].hasImage) return R.layout.mylayout_with_image
//        else R.layout.mylayout_no_image;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
       val viewBinding = ListItemTtlBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(ttlList[position])
    }

    override fun getItemCount(): Int = ttlList.size


}