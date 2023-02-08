package com.example.i.market

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.i.R
import com.example.i.databinding.FragmentPpl3Binding

class Ppl3Fragment : Fragment() {

    private lateinit var viewBinding: FragmentPpl3Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentPpl3Binding.inflate(inflater, container, false)

        return viewBinding.root
    }
}