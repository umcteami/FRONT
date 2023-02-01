package com.example.i.mypage.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.i.R
import com.example.i.databinding.FragmentRevokeBinding

class RevokeFragment : Fragment() {

    private lateinit var viewBinding: FragmentRevokeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentRevokeBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return viewBinding.root
    }
}