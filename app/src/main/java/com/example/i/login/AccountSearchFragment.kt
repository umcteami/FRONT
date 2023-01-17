package com.example.i.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.example.i.R

class AccountSearchFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_account_search, container, false)
        val bt_call = rootView.findViewById<Button>(R.id.bt_call)
        val activity = activity as LoginActivity

        //인증번호 받기
        bt_call.setOnClickListener{
            activity.changeFragment(3)
        }
        return rootView
    }
}