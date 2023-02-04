package com.example.i.signup

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.i.MainActivity
import com.example.i.databinding.FragmentEtcBinding

class EtcFragment : Fragment() {
    private lateinit var viewBinding : FragmentEtcBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentEtcBinding.inflate(inflater, container, false)

        viewBinding.backBtn.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }

        val activity = activity as SignupActivity

        viewBinding.btEnd1.setOnClickListener{
            activity.changeFragment(7)
        }

        viewBinding.btEnd2.setOnClickListener {
            activity.changeFragment(8)
        }

        return viewBinding.root
    }
}