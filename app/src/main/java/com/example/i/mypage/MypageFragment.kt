package com.example.i.mypage

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.i.databinding.FragmentMypageBinding
import com.example.i.home.HomeFragment

class MypageFragment : Fragment() {
    private lateinit var viewBinding: FragmentMypageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentMypageBinding.inflate(layoutInflater)

        setUpSetting()

        return viewBinding.root
    }

    private fun setUpSetting() {
        viewBinding.mypageSettingBtn.setOnClickListener {
            activity?.let{
                val intent = Intent(context, mypageSetting::class.java)
                intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION)
                startActivity(intent)
            }
        }
    }

    private fun setUpPost() {
        viewBinding.myPostList.setOnClickListener{

        }

    }
}