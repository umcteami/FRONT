package com.example.i.market

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.i.R
import com.example.i.databinding.FragmentPpl2Binding

class Ppl2Fragment : Fragment() {

    private lateinit var viewBinding: FragmentPpl2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentPpl2Binding.inflate(inflater, container, false)

        val item = mutableListOf<MarketP>()

        item.add(MarketP(R.drawable.img_post, "무료나눔", "강아지껌", "2"))
        item.add(MarketP(R.drawable.img_post, "무료나눔", "강아지껌", "2"))
        item.add(MarketP(R.drawable.img_post, "무료나눔", "강아지껌", "2"))
        item.add(MarketP(R.drawable.img_post, "무료나눔", "강아지껌", "2"))
        item.add(MarketP(R.drawable.img_post, "무료나눔", "강아지껌", "2"))
        item.add(MarketP(R.drawable.img_post, "무료나눔", "강아지껌", "2"))

        val adapter = MarketGVAdapter(item)
        viewBinding.gvPpl.adapter = adapter

        viewBinding.gvPpl.setOnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(activity, MarketPostActivity::class.java)
            startActivity(intent)
        }

        return viewBinding.root
    }
}