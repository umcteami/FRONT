package com.example.i.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.i.databinding.FragmentNicknameBinding

class NicknameFragment : Fragment() {
    private lateinit var viewBinding : FragmentNicknameBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentNicknameBinding.inflate(layoutInflater)
        return viewBinding.root
    }
}