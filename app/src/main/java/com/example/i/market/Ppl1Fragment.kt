package com.example.i.market

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.i.R
import com.example.i.databinding.FragmentPpl1Binding

class Ppl1Fragment : Fragment() {

    private lateinit var viewBinding: FragmentPpl1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentPpl1Binding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return viewBinding.root
    }
}