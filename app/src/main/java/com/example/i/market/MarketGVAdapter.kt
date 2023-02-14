package com.example.i.market

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.i.databinding.ItemMarket3Binding

class MarketGVAdapter(private val items: MutableList<MarketP>, private var context: Context): BaseAdapter() {
    override fun getCount(): Int = items.size

    override fun getItem(position: Int): MarketP = items[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        var viewBinding =  ItemMarket3Binding.inflate(LayoutInflater.from(parent?.context), parent, false)

        val item: MarketP = items[position]
        Glide.with(viewBinding.ivMk)
            .load(item.image)
            .into(viewBinding.ivMk)
        viewBinding.tvMkTitle.text = item.title
        viewBinding.tvMkContent.text = item.content
        viewBinding.tvMkView.text = item.view
        viewBinding.cbHeart.isChecked = item.liked

        viewBinding.cbHeart.setOnCheckedChangeListener { compoundButton, b ->
            if (viewBinding.cbHeart.isChecked == true) {
                item.view + 1
                Toast.makeText(context, "게시글을 찜 했습니다.", Toast.LENGTH_SHORT).show()
                viewBinding.tvMkView.text = item.view
            }
            else {
                item.view + 1
                Toast.makeText(context, "게시글 찜을 해제했습니다.", Toast.LENGTH_SHORT).show()
                viewBinding.tvMkView.text = item.view
            }
        }

        return viewBinding.root
    }
}