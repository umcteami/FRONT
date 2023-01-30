package com.example.i.mypage.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.i.R

class LikeInformationFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_like_information, container, false)
    }

    fun newInstant(): LikeInformationFragment {
        val args = Bundle()
        val frag = LikeInformationFragment()
        frag.arguments = args
        return frag
    }
}