package com.example.i.mypage.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.i.R

class LikeDiaryFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_like_diary, container, false)
    }

    fun newInstant(): LikeDiaryFragment {
        val args = Bundle()
        val frag = LikeDiaryFragment()
        frag.arguments = args
        return frag
    }
}