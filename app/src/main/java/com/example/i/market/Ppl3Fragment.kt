package com.example.i.market

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.i.databinding.FragmentPpl3Binding

class Ppl3Fragment : Fragment() {

    private lateinit var viewBinding: FragmentPpl3Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentPpl3Binding.inflate(inflater, container, false)

        var img = "https://i-image.s3.ap-northeast-2.amazonaws.com/8568310d-73fb-4728-b11f-712d716c6416_Acer_Wallpaper_03_5000x2814.jpg"

        val item = mutableListOf<MarketP>()

        item.apply{
            add(MarketP(img, "간식 나눔", "강아지 껌", "2", false))
            add(MarketP(img, "간식 나눔", "강아지 껌", "2", false))
            add(MarketP(img, "간식 나눔", "강아지 껌", "2", true))
            add(MarketP(img, "간식 나눔", "강아지 껌", "2", true))
            add(MarketP(img, "간식 나눔", "강아지 껌", "2", false))
            add(MarketP(img, "간식 나눔", "강아지 껌", "2", true))
        }

        val adapter = MarketGVAdapter(item, requireActivity())
        viewBinding.gvPpl.adapter = adapter

        viewBinding.gvPpl.setOnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(activity, MarketPostActivity::class.java)
            startActivity(intent)
        }

        return viewBinding.root
    }
}