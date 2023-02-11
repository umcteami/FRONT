package com.example.i.chat

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.i.databinding.ItemMeChatBinding
import com.example.i.databinding.ItemYouChatBinding

class ChatRVAdpater(private val meList: ArrayList<ChatMe>, private val youList: ArrayList<ChatYou>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class meHolder(val viewBinding: ItemMeChatBinding): RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(me: ChatMe) {
            viewBinding.tvMessage.text = me.content
            viewBinding.tvDate.text = me.time
            if (me.Check) {
                viewBinding.ivShow.visibility = View.VISIBLE
            }
        }
    }

    inner class youHolder(val viewBinding: ItemYouChatBinding): RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(you: ChatYou) {
            viewBinding.tvMessage.text = you.content

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


}