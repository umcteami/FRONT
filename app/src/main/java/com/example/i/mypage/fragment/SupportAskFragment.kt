package com.example.i.mypage.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.i.databinding.FragmentSupportAskBinding
import com.example.i.databinding.FragmentSupportHelpBinding

class SupportAskFragment : Fragment() {

    private lateinit var viewBinding: FragmentSupportAskBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentSupportAskBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment

        return viewBinding.root
    }
}