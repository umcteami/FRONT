package com.example.i.market

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

        return viewBinding.root
    }
}