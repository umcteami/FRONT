package com.example.i.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.i.databinding.FragmentEmailBinding

class EmailFragment : Fragment() {
    private lateinit var viewBinding : FragmentEmailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentEmailBinding.inflate(layoutInflater)
        return viewBinding.root
    }
}