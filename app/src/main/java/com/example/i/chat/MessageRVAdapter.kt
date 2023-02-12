package com.example.i.chat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.i.R
import com.example.i.databinding.ItemMessageListBinding

class MessageRVAdapter(private val mList: ArrayList<Message>): RecyclerView.Adapter<MessageRVAdapter.ViewHolder>() {

    var itemClick: ItemClick? = null
    var itemLongClick: ItemLongClick? = null

    inner class ViewHolder(val viewBinding: ItemMessageListBinding): RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(Message: Message) {
            Glide.with(viewBinding.ivProfile)
                .load(Message.profile)
                .into(viewBinding.ivProfile)
            viewBinding.tvNickname.text = Message.nickname
            viewBinding.tvChat.text = Message.chat
            viewBinding.tvTime.text = Message.time
            if (Message.num?.isEmpty() == true || Message.num!!.equals("0")){
                viewBinding.tvNum.visibility = View.INVISIBLE
            }
            else {
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

        if (itemLongClick != null) {
            holder.viewBinding!!.itemMessageList.setOnLongClickListener(View.OnLongClickListener {
                itemLongClick?.onClick(it, position)

                return@OnLongClickListener true
            })
        }
        if (itemClick != null) {

            holder.viewBinding!!.itemMessageList.setOnClickListener(View.OnClickListener {
                itemClick?.onClick(it, holder.viewBinding!!.tvNickname.text ,position)
            })
        }
    }

    override fun getItemCount(): Int = mList.size

    interface ItemClick {
        fun onClick(view: View, data: CharSequence, position: Int)
    }

    interface ItemLongClick {
        fun onClick(view: View, position: Int)
    }
}