package com.example.i.mypage.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.i.databinding.ItemBlockedBinding

class BlockedRVAdapter(private val BlockList: ArrayList<Blocked>): RecyclerView.Adapter<BlockedRVAdapter.ViewHolder>() {
    inner class ViewHolder(private val viewBinding: ItemBlockedBinding): RecyclerView.ViewHolder(viewBinding.root) {
        fun bind (Blocked: Blocked) {
            viewBinding.blockedName.text = Blocked.name
            viewBinding.blockedContent.text = Blocked.content
            viewBinding.btBlocked.isSelected = true

            // 버튼 눌린 상태
            viewBinding.btBlocked.setOnClickListener {
                viewBinding.btBlocked.isSelected = viewBinding.btBlocked.isSelected != true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding =  ItemBlockedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(BlockList[position])
    }

    override fun getItemCount(): Int = BlockList.size
}