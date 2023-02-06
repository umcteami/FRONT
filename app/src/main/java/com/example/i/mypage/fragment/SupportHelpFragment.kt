package com.example.i.mypage.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.i.databinding.FragmentRevokeBinding
import com.example.i.databinding.FragmentSupportHelpBinding

class SupportHelpFragment : Fragment() {

    private lateinit var viewBinding: FragmentSupportHelpBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentSupportHelpBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment

        clickEvent()
        return viewBinding.root
    }

    private fun clickEvent(){
        viewBinding.layoutBtn1.setOnClickListener {
            if(viewBinding.layout01A.visibility == View.VISIBLE) {
                viewBinding.layout01A.visibility = View.GONE
                viewBinding.layoutBtn1.animate().apply {
                    duration = 300
                    rotation(0f)
                }
            }else {
                viewBinding.layout01A.visibility = View.VISIBLE
                viewBinding.layoutBtn1.animate().apply {
                    duration = 300
                    rotation(180f)
                }
            }
        }

        viewBinding.layoutBtn2.setOnClickListener {
            if(viewBinding.layout02A.visibility == View.VISIBLE) {
                viewBinding.layout02A.visibility = View.GONE
                viewBinding.layoutBtn2.animate().apply {
                    duration = 300
                    rotation(0f)
                }
            }else {
                viewBinding.layout02A.visibility = View.VISIBLE
                viewBinding.layoutBtn2.animate().apply {
                    duration = 300
                    rotation(180f)
                }
            }
        }

        viewBinding.layoutBtn3.setOnClickListener {
            if(viewBinding.layout03A.visibility == View.VISIBLE) {
                viewBinding.layout03A.visibility = View.GONE
                viewBinding.layoutBtn3.animate().apply {
                    duration = 300
                    rotation(0f)
                }
            }else {
                viewBinding.layout03A.visibility = View.VISIBLE
                viewBinding.layoutBtn3.animate().apply {
                    duration = 300
                    rotation(180f)
                }
            }
        }

        viewBinding.layoutBtn4.setOnClickListener {
            if(viewBinding.layout04A.visibility == View.VISIBLE) {
                viewBinding.layout04A.visibility = View.GONE
                viewBinding.layoutBtn4.animate().apply {
                    duration = 300
                    rotation(0f)
                }
            }else {
                viewBinding.layout04A.visibility = View.VISIBLE
                viewBinding.layoutBtn4.animate().apply {
                    duration = 300
                    rotation(180f)
                }
            }
        }

        viewBinding.layoutBtn5.setOnClickListener {
            if(viewBinding.layout05A.visibility == View.VISIBLE) {
                viewBinding.layout05A.visibility = View.GONE
                viewBinding.layoutBtn5.animate().apply {
                    duration = 300
                    rotation(0f)
                }
            }else {
                viewBinding.layout05A.visibility = View.VISIBLE
                viewBinding.layoutBtn5.animate().apply {
                    duration = 300
                    rotation(180f)
                }
            }
        }

        viewBinding.layoutBtn6.setOnClickListener {
            if(viewBinding.layout06A.visibility == View.VISIBLE) {
                viewBinding.layout06A.visibility = View.GONE
                viewBinding.layoutBtn6.animate().apply {
                    duration = 300
                    rotation(0f)
                }
            }else {
                viewBinding.layout06A.visibility = View.VISIBLE
                viewBinding.layoutBtn6.animate().apply {
                    duration = 300
                    rotation(180f)
                }
            }
        }


    }
}