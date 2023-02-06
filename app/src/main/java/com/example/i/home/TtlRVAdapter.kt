package com.example.i.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.i.databinding.ListItemTtl2Binding
import com.example.i.databinding.ListItemTtlBinding
import com.example.i.home.Const.HASIMAGE
import com.example.i.home.Const.NOIMAGE


class TtlRVAdapter(private val ttlList:ArrayList<Ttls>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class TtlWithImageViewHolder(private val viewBinding: ListItemTtlBinding) :
    RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(ttls: Ttls) {
            viewBinding.ttlTitle.text = ttls.title
            viewBinding.ttlPicture.setImageResource(ttls.picture!!)
            viewBinding.ttlWriter.text = ttls.writer
            viewBinding.ttlDate.text = ttls.date
            viewBinding.ttlViewNum.text = ttls.view
            viewBinding.ttlHaertNum.text = ttls.heart
            viewBinding.tlCommentNum.text = ttls.comment
        }
    }

    inner class TtlWithoutImageViewHolder(private val viewBinding: ListItemTtl2Binding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(ttls: Ttls) {
            viewBinding.ttlTitle.text = ttls.title
            viewBinding.ttlWriter.text = ttls.writer
            viewBinding.ttlDate.text = ttls.date
            viewBinding.ttlViewNum.text = ttls.view
            viewBinding.ttlHaertNum.text = ttls.heart
            viewBinding.tlCommentNum.text = ttls.comment
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (ttlList[position].hasImage == HasImage.TRUE) HASIMAGE else NOIMAGE
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == HASIMAGE) {
           val view = ListItemTtlBinding.inflate(LayoutInflater.from(parent.context),parent, false)
            TtlWithImageViewHolder(view)
        } else {
            val view = ListItemTtl2Binding.inflate(LayoutInflater.from(parent.context),parent,false)
            TtlWithoutImageViewHolder(view)
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       if (getItemViewType(position) == HASIMAGE) {
           (holder as TtlWithImageViewHolder).bind(ttlList[position])
       }else {
           (holder as TtlWithoutImageViewHolder).bind(ttlList[position])
       }
    }

    override fun getItemCount(): Int = ttlList.size

}

private object Const {
    const val HASIMAGE = 0
    const val NOIMAGE = 1
}