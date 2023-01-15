package com.example.i.Signup


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.i.databinding.FragmentPhoneCodeBinding

class PhoneCodeFragment : Fragment() {
    private lateinit var viewBinding : FragmentPhoneCodeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentPhoneCodeBinding.inflate(layoutInflater)
        return viewBinding.root
    }
}