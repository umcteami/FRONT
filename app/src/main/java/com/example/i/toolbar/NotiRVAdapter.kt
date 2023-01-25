package com.example.i.toolbar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.i.databinding.ListItemNotiBinding

class NotiRVAdapter(private val notiList: ArrayList<Noti>): RecyclerView.Adapter<NotiRVAdapter.DataViewHolder>() {
    inner class DataViewHolder(private val viewBinding: ListItemNotiBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind (noti: Noti) {
            viewBinding.notiCategory.text = noti.category
            viewBinding.notiUsername.text = noti.username
            viewBinding.notiSentence.text = noti.sentence
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val viewBinding = ListItemNotiBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DataViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(notiList[position])
    }

    override fun getItemCount(): Int = notiList.size


}