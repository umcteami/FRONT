package com.example.i.mypage

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.i.databinding.FragmentMypageBinding

class MypageFragment : Fragment() {
    private lateinit var viewBinding: FragmentMypageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentMypageBinding.inflate(layoutInflater)

        setUpView()

//        viewBinding.homeToolbar.setOnMenuItemClickListener {
//            when (it.itemId) {
//
//                R.id.home_search -> {
//                    val intent = Intent(context, SearchActivity::class.java)
//                    intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION)
//                    startActivity(intent)
//                    true
//                }
//                R.id.home_noti -> {
//                    val intent = Intent(context, NotiActivity::class.java)
//                    startActivity(intent)
//                    true
//                }
//                else -> false
//            }
//        }

        return viewBinding.root
    }

    private fun setUpView() {
        viewBinding.mypageSettingBtn.setOnClickListener {
            activity?.let{
                val intent = Intent(context, mypageSetting::class.java)
                intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION)
                startActivity(intent)
            }
        }
    }
}