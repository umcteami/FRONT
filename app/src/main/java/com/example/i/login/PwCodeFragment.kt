package com.example.i.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import com.example.i.R

class PwCodeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_pw_code, container, false)
        val bt_ok = rootView.findViewById<Button>(R.id.bt_ok)
        val activity = activity as LoginActivity

        //비번 재설정
        bt_ok.setOnClickListener{
            activity.changeFragment(6)
        }
        return rootView
    }
}