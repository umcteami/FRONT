package com.example.i.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.i.databinding.FragmentChattingBinding

class ChattingFragment:Fragment() {
    private lateinit var viewBinding: FragmentChattingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentChattingBinding.inflate(layoutInflater)
        return viewBinding.root
    }
}