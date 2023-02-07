package com.example.i.chat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.i.databinding.ItemMessageListBinding

class MessageRVAdapter(private val mList: ArrayList<Message>): RecyclerView.Adapter<MessageRVAdapter.ViewHolder>() {

    var itemClick: ItemClick? = null

    inner class ViewHolder(val viewBinding: ItemMessageListBinding): RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(Message: Message) {
            viewBinding.tvNickname.text = Message.nickname
            viewBinding.tvChat.text = Message.chat
            viewBinding.tvTime.text = Message.time
            if (Message.num != ""){
                viewBinding.tvNum.visibility=View.VISIBLE
                viewBinding.tvNum.text = Message.num
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemMessageListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mList[position])

        if (itemClick != null){
            holder?.viewBinding!!.itemMessageList.setOnClickListener(View.OnClickListener {
                itemClick?.onClick(it, position)
            })
        }
    }

    override fun getItemCount(): Int = mList.size

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }
}