package com.example.i.market

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.i.databinding.FragmentSnackBinding

class SnackFragment: Fragment() {

    private lateinit var viewBinding: FragmentSnackBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentSnackBinding.inflate(layoutInflater)

        return viewBinding.root
    }
}