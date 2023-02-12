package com.example.i.chat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.i.databinding.ItemChatDateBinding
import com.example.i.databinding.ItemMeChatBinding
import com.example.i.databinding.ItemYouChatBinding
import java.text.SimpleDateFormat


class ChatRVAdpater(private val cList: ArrayList<Chat>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class meHolder(private val viewBinding: ItemMeChatBinding): RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(chat: Chat) {
            viewBinding.tvMessage.text = chat.message

            val formatter = SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
            val date = formatter.parse(chat.date_time)

            val sdf = SimpleDateFormat("hh:mm")

            val getTime = sdf.format(date)
            viewBinding.tvDate.text = getTime

            if (chat.check == true) {
                viewBinding.ivShow.visibility = View.VISIBLE
            }
            else {
                viewBinding.ivShow.visibility = View.INVISIBLE
            }
        }
    }

    inner class youHolder(private val viewBinding2: ItemYouChatBinding): RecyclerView.ViewHolder(viewBinding2.root) {
        fun bind(chat: Chat) {
            Glide.with(viewBinding2.ivProfile)
                .load(chat.profile)
                .into(viewBinding2.ivProfile)
            if (chat.chatImg != null) {
                Glide.with(viewBinding2.tvMessage)
                    .load(chat.profile)
                    .into(viewBinding2.ivProfile)
            }
            viewBinding2.tvMessage.text = chat.message
            val formatter = SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
            val date = formatter.parse(chat.date_time)

            val sdf = SimpleDateFormat("hh:mm")

            val getTime = sdf.format(date)
            viewBinding2.tvDate.text = getTime
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (cList[position].sender == cList[position].memIdx) 1 else 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == 1) {
            val view = ItemMeChatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return meHolder(view)
        }
        else {
            val view = ItemYouChatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return youHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == 1) {
            (holder as meHolder).bind(cList[position])
        }
        else {
            (holder as youHolder).bind(cList[position])
        }
    }

    override fun getItemCount(): Int = cList.size

}