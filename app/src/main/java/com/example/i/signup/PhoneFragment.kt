package com.example.i.signup


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.i.databinding.FragmentPhoneBinding

class PhoneFragment : Fragment() {
    private lateinit var viewBinding : FragmentPhoneBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentPhoneBinding.inflate(layoutInflater)
        return viewBinding.root
    }
}