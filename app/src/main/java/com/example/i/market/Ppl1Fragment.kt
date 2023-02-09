package com.example.i.market

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import com.example.i.R
import com.example.i.databinding.FragmentPpl1Binding

class Ppl1Fragment : Fragment() {

    private lateinit var viewBinding: FragmentPpl1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentPpl1Binding.inflate(inflater, container, false)

        val item = mutableListOf<MarketP>()

        item.add(MarketP(R.drawable.img_post, "무료나눔", "강아지껌", "2"))
        item.add(MarketP(R.drawable.img_post, "무료나눔", "강아지껌", "2"))
        item.add(MarketP(R.drawable.img_post, "무료나눔", "강아지껌", "2"))
        item.add(MarketP(R.drawable.img_post, "무료나눔", "강아지껌", "2"))
        item.add(MarketP(R.drawable.img_post, "무료나눔", "강아지껌", "2"))
        item.add(MarketP(R.drawable.img_post, "무료나눔", "강아지껌", "2"))

        val adapter = MarketGVAdapter(item, requireActivity())
        viewBinding.gvPpl.adapter = adapter

        viewBinding.gvPpl.setOnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(activity, MarketPostActivity::class.java)
            startActivity(intent)
        }

        return viewBinding.root
    }
}