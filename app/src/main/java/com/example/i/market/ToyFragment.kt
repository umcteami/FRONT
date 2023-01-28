package com.example.i.market

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.i.databinding.FragmentToyBinding

class ToyFragment: Fragment() {

    private lateinit var viewBinding: FragmentToyBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentToyBinding.inflate(layoutInflater)

        return viewBinding.root
    }
}