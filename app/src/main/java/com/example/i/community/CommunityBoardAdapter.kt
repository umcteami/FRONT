package com.example.i.community

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.i.R

class CommunityBoardAdapter(val itemList: ArrayList<BoardItem>) :
RecyclerView.Adapter<CommunityBoardAdapter.BoardViewHolder>(){
    override fun onCreateViewHolder(parent : ViewGroup, viewType: Int): BoardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_list_layout, parent, false)
        return BoardViewHolder(view)
    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        holder.tv_time.text = itemList[position].time
        holder.tv_title.text=  itemList[position].title
        holder.tv_writer.text= itemList[position].name
    }

    override fun getItemCount(): Int {
        return itemList.count()
    }

    inner class BoardViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val tv_time = itemView.findViewById<TextView>(R.id.tv_writeTime)
        val tv_title = itemView.findViewById<TextView>(R.id.tv_title)
        val tv_writer = itemView.findViewById<TextView>(R.id.tv_writer)
    }
}