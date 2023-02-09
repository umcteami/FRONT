package com.example.i.market

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.i.databinding.ItemMarket2Binding

class MarketRVAdapter(private val mkList: ArrayList<Market>, private var context: Context): RecyclerView.Adapter<MarketRVAdapter.ViewHolder>() {

    var itemClick: MarketRVAdapter.ItemClick? = null

    inner class ViewHolder(val viewBinding: ItemMarket2Binding): RecyclerView.ViewHolder(viewBinding.root) {
        fun bind (Market: Market) {
            viewBinding.tvTitle.text = Market.title
            viewBinding.tvContent.text = Market.content
            viewBinding.tvView.text = Market.view
            viewBinding.tvTime.text = Market.time
            viewBinding.tvNum.text = Market.num
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding =  ItemMarket2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mkList[position])

        if (itemClick != null) {

            holder.viewBinding!!.itemMarket2.setOnClickListener(View.OnClickListener {
                itemClick?.onClick(it, position)
            })

            holder.viewBinding.cbHeart.setOnCheckedChangeListener { compoundButton, b ->
                if (holder.viewBinding.cbHeart.isChecked == true) {
                    Toast.makeText(context, "게시글을 찜 했습니다.", Toast.LENGTH_SHORT).show()
                }
                else {
                    Toast.makeText(context, "게시글 찜을 해제했습니다.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun getItemCount(): Int = mkList.size

    override fun getItemViewType(position: Int): Int {
        return position
    }

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }
}