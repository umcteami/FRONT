package com.example.i.mypage.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.i.databinding.ItemListAnnounceBinding

class AnncmRVAdapter (private val anncmList: ArrayList<Anncms>): RecyclerView.Adapter<AnncmRVAdapter.DataViewHolder>() {

    inner class DataViewHolder(private val viewBinding: ItemListAnnounceBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(anncms: Anncms) {
            viewBinding.anncmTitle.text = anncms.title
            viewBinding.anncmDate.text = anncms.date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val viewBinding = ItemListAnnounceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(viewBinding)
    }
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(anncmList[position])
    }
    override fun getItemCount(): Int = anncmList.size

}