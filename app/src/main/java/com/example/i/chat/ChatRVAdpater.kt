package com.example.i.chat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.i.databinding.ItemMeChatBinding
import com.example.i.databinding.ItemYouChatBinding


class ChatRVAdpater(private val cList: ArrayList<Chat>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    inner class meHolder(private val viewBinding: ItemMeChatBinding): RecyclerView.ViewHolder(viewBinding.root) {
        fun mbind(chat: Chat) {
            viewBinding.tvMessage.text = chat.message
            viewBinding.tvDate.text = chat.date_time
            if (chat.check == true) {
                viewBinding.ivShow.visibility = View.VISIBLE
            }
            else {
                viewBinding.ivShow.visibility = View.INVISIBLE
            }
        }
    }

    inner class youHolder(private val viewBinding: ItemYouChatBinding): RecyclerView.ViewHolder(viewBinding.root) {
        fun ybind(chat: Chat) {
            Glide.with(viewBinding.ivProfile)
                .load(chat.profile)
                .into(viewBinding.ivProfile)
            viewBinding.tvMessage.text = chat.message
            viewBinding.tvDate.text = chat.date_time
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == 1) {
            val viewBinding = ItemMeChatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return meHolder(viewBinding)
        }
        else {
            val viewBinding = ItemYouChatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return youHolder(viewBinding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is meHolder) {
            (holder as meHolder).mbind(cList[position])
        }
        else {
            (holder as youHolder).ybind(cList[position])
        }
    }

    override fun getItemCount(): Int = cList.size

}