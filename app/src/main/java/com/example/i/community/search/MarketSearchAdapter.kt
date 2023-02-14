package com.example.i.community.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.i.databinding.ItemMarket2Binding
import com.example.i.market.Market

class MarketSearchAdapter (val mkList : ArrayList<Market>) :
RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    var itemClick : MarketSearchAdapter.ItemClick? = null

    inner class ViewHolder(val viewBinding : ItemMarket2Binding) : RecyclerView.ViewHolder(viewBinding.root){
        fun bind(Market : Market){
            viewBinding.tvTitle.text = Market.title
            viewBinding.tvPrice.text = Market.price.toString()
            viewBinding.tvDate.text = Market.date
            viewBinding.tvViewCnt.text =  Market.view.toString()
            viewBinding.tvHeartCnt.text = Market.hearNum.toString()
            Glide.with(viewBinding.marketPostPicture)
                .load(Market.image)
                .into(viewBinding.marketPostPicture)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewBinding = ItemMarket2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(mkList[position])

        if(itemClick != null){
            (holder as MarketSearchAdapter.ViewHolder).viewBinding!!.itemMarket2.setOnClickListener(View.OnClickListener {
                itemClick?.onClick(it, position)
            })

//            holder.viewBinding.cbHeart.setOnClickListener { compoundButton, b ->
//                if(holder.viewBinding.cbHeart.isChecked == true){
//                    Toast.makeText(context, "게시글을 찜 했습니다.", Toast.LENGTH_SHORT).show()
//                }
//                else {
//                    Toast.makeText(context, "게시글 찜을 해제했습니다.", Toast.LENGTH_SHORT).show()
//                }
//            }
        }
    }

    override fun getItemCount(): Int {
        return mkList.count()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    interface ItemClick{
        fun onClick(view : View, position : Int)
    }
}