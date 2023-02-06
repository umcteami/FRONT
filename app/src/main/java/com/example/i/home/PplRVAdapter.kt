package com.example.i.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.i.databinding.ListItemPpl2Binding
import com.example.i.databinding.ListItemPplBinding
import com.example.i.databinding.ListItemTtl2Binding
import com.example.i.databinding.ListItemTtlBinding


class PplRVAdapter (private val pplList: ArrayList<Ppls>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class PplWithImageViewHolder(private val viewBinding: ListItemPplBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(ppls: Ppls) {
            viewBinding.pplTitle.text = ppls.title
            viewBinding.pplPicture.setImageResource(ppls.picture!!)
            viewBinding.pplWriter.text = ppls.writer
            viewBinding.pplDate.text = ppls.date
            viewBinding.pplView.text = ppls.view
            viewBinding.pplCommentNum.text = ppls.comment
            viewBinding.pplHaertNum.text = ppls.heart
        }
    }

    inner class PplWithoutImageViewHolder(private val viewBinding: ListItemPpl2Binding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(ppls: Ppls) {
            viewBinding.pplTitle.text = ppls.title
            viewBinding.pplWriter.text = ppls.writer
            viewBinding.pplDate.text = ppls.date
            viewBinding.pplView.text = ppls.view
            viewBinding.pplCommentNum.text = ppls.comment
            viewBinding.pplHaertNum.text = ppls.heart
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
        if (getItemViewType(position) == Const.HASIMAGE) {
            (holder as PplRVAdapter.PplWithImageViewHolder).bind(pplList[position])
        }else {
            (holder as PplRVAdapter.PplWithoutImageViewHolder).bind(pplList[position])
        }
    }
    override fun getItemCount(): Int = pplList.size
}

