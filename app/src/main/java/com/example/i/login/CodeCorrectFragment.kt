package com.example.i.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import com.example.i.R

class CodeCorrectFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_code_correct, container, false)
        val bt_ok = rootView.findViewById<Button>(R.id.bt_ok)
        val bt_find_pw = rootView.findViewById<Button>(R.id.bt_find_pw)

        val activity = activity as LoginActivity

        // 로그인 화면으로 이동
        bt_ok.setOnClickListener{
            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
        }

        // 비밀번호 찾기
        bt_find_pw.setOnClickListener{
            activity.changeFragment(2)
        }
        return rootView
    }
}