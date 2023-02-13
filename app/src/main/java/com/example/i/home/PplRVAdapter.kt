package com.example.i.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.i.databinding.ListItemPpl2Binding
import com.example.i.databinding.ListItemPplBinding

class PplRVAdapter (private val pplList: ArrayList<Ppls>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var itemClick: PplRVAdapter.ItemClick? = null

    inner class PplWithImageViewHolder(val viewBinding: ListItemPplBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(ppls: Ppls) {
            viewBinding.pplTitle.text = ppls.title
            Glide.with(viewBinding.pplImg)
                .load(ppls.picture)
                .into(viewBinding.pplImg)
            viewBinding.pplType.text = ppls.type
            viewBinding.pplWriter.text = ppls.writer
            viewBinding.pplDate.text = ppls.date
            viewBinding.pplViewNum.text = ppls.view
            viewBinding.pplHaertNum.text = ppls.heart
            viewBinding.pplCommentNum.text = ppls.comment
        }
    }

    inner class PplWithoutImageViewHolder(val viewBinding2: ListItemPpl2Binding) :
        RecyclerView.ViewHolder(viewBinding2.root) {
        fun bind(ppls: Ppls) {
            viewBinding2.pplTitle.text = ppls.title
            viewBinding2.pplWriter.text = ppls.writer
            viewBinding2.pplDate.text = ppls.date
            viewBinding2.pplViewNum.text = ppls.view
            viewBinding2.pplHaertNum.text = ppls.heart
            viewBinding2.pplCommentNum.text = ppls.comment
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (pplList[position].hasImage == HasImage.TRUE) Const.HASIMAGE else Const.NOIMAGE
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == Const.HASIMAGE) {
            val view = ListItemPplBinding.inflate(LayoutInflater.from(parent.context),parent, false)
            PplWithImageViewHolder(view)
        } else {
            val view = ListItemPpl2Binding.inflate(LayoutInflater.from(parent.context),parent,false)
            PplWithoutImageViewHolder(view)
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) ==  Const.HASIMAGE) {
            (holder as PplRVAdapter.PplWithImageViewHolder).bind(pplList[position])
        }else {
            (holder as PplRVAdapter.PplWithoutImageViewHolder).bind(pplList[position])
        }

        if (itemClick != null) {
            if (pplList[position].hasImage == HasImage.TRUE) {
                (holder as PplRVAdapter.PplWithImageViewHolder).viewBinding!!.itemPpl.setOnClickListener(View.OnClickListener {
                    itemClick?.onClick(it, position)
                })
            } else {
                (holder as PplRVAdapter.PplWithoutImageViewHolder).viewBinding2!!.itemPpl2.setOnClickListener(View.OnClickListener {
                    itemClick?.onClick(it, position)
                })
            }
        }
    }
    override fun getItemCount(): Int = pplList.size

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

}


