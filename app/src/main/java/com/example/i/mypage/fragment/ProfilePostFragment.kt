package com.example.i.mypage.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.i.databinding.FragmentProfilePostBinding


class ProfilePostFragment : Fragment() {

    private lateinit var viewBinding: FragmentProfilePostBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentProfilePostBinding.inflate(inflater, container, false)

        return viewBinding.root
    }
}