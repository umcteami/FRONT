package com.example.i.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.i.databinding.ListItemTtl2Binding
import com.example.i.databinding.ListItemTtlBinding
import com.example.i.home.Const.HASIMAGE
import com.example.i.home.Const.NOIMAGE

class TtlRVAdapter(private val ttlList: ArrayList<Ttls>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var itemClick: TtlRVAdapter.ItemClick? = null

    inner class TtlWithImageViewHolder(val viewBinding: ListItemTtlBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(ttls: Ttls) {
            viewBinding.ttlTitle.text = ttls.title
            Glide.with(viewBinding.ttlImg)
                .load(ttls.picture)
                .into(viewBinding.ttlImg)
            viewBinding.ttlType.text = ttls.type
            viewBinding.ttlWriter.text = ttls.writer
            viewBinding.ttlDate.text = ttls.date
            viewBinding.ttlViewNum.text = ttls.view
            viewBinding.ttlHaertNum.text = ttls.heart
            viewBinding.tlCommentNum.text = ttls.comment
        }
    }

    inner class TtlWithoutImageViewHolder(val viewBinding2: ListItemTtl2Binding) :
        RecyclerView.ViewHolder(viewBinding2.root) {
        fun bind(ttls: Ttls) {
            viewBinding2.ttlTitle.text = ttls.title
            viewBinding2.ttlWriter.text = ttls.writer
            viewBinding2.ttlDate.text = ttls.date
            viewBinding2.ttlViewNum.text = ttls.view
            viewBinding2.ttlHaertNum.text = ttls.heart
            viewBinding2.tlCommentNum.text = ttls.comment
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

        if (itemClick != null) {
            if (ttlList[position].hasImage == HasImage.TRUE) {
                (holder as TtlRVAdapter.TtlWithImageViewHolder).viewBinding!!.itemTtl.setOnClickListener(
                    View.OnClickListener {
                        itemClick?.onClick(it, position)
                    })
            }  else {
                (holder as TtlRVAdapter.TtlWithoutImageViewHolder).viewBinding2!!.itemTtl2.setOnClickListener(
                    View.OnClickListener {
                        itemClick?.onClick(it, position)
                    })
            }
        }
    }

    override fun getItemCount(): Int = ttlList.size

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

}

object Const {
    const val HASIMAGE = 0
    const val NOIMAGE = 1
}